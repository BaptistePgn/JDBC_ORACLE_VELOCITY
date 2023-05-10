package dao;

import bd.OracleSession;
import bd.SQLError;
import bean.Attribut;
import bean.Procedure;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatementGeneratorVelocity {
    // Generate all CRUD statements for all tables
    public static void generateAll() throws SQLError {
        try {
            OracleSession session = new OracleSession();
            Statement stmt = session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT table_name FROM user_tables");
            while(resultat.next()) {
                String tn = resultat.getString("table_name");
                if (!tn.contains("$")) {
                    generate(tn);
                }
            }
            session.closeConn();
        } catch (SQLException e) {
            throw (new SQLError(e.getErrorCode(), e.getMessage()));
        }
    }

    // Generate CRUD statements for one table
    public static void generate(String table) throws SQLError {
        try {
            OracleSession session = new OracleSession();
            VelocityContext context = new VelocityContext();

            String tn = table.substring(0, 1) + table.substring(1).toLowerCase();

            ArrayList<Attribut> list= new ArrayList<Attribut>();
            context.put("Table", tn);
            context.put("TableDAO", tn+"DAO");

            Statement stmt = session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM "+table);
            ResultSetMetaData rsmd = resultat.getMetaData();

            // Get all attributes
            for (int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
                String cn = rsmd.getColumnName(i);
                Attribut a = new Attribut(cn, rsmd.getColumnClassName(i));
                list.add(a);
            }

            // Get all primary keys
            List<Attribut> clePrimaires = new ArrayList();
            DatabaseMetaData dbmd = session.getConn().getMetaData();
            ResultSet rsKey = dbmd.getPrimaryKeys(session.getConn().getCatalog(), null, table.toUpperCase());
            while (rsKey.next()) {
                String columnName = rsKey.getString("COLUMN_NAME").toLowerCase();
                clePrimaires.add(new Attribut(columnName, list.stream().filter(a -> a.getFormat().equals(columnName)).findFirst().get().getTypeName()));
            }
            // Put all attributes in the context
            context.put("clePrimaires", clePrimaires);
            context.put("import", "\n\n import bean."+tn+";" +
                    "\n import java.util.ArrayList;" +
                    "\n import java.util.List;" +
                    "\n import bd.OracleSession;" +
                    "\n import java.sql.*;"+
                    "\n import java.math.BigDecimal;");
            context.put("AttributsList", list);
            save(tn + "DAO" , context);

        } catch (SQLException e) {
            throw (new SQLError(e.getErrorCode(), e.getMessage()));
        }
    }
    // Save the generated file
    private static void save(String name, VelocityContext context) {
        try {
            VelocityEngine ve = new VelocityEngine();
            Template t = ve.getTemplate( "./ressources/Statement.vm" );
            File file= new File("./dao/"+name+".java");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            t.merge(context, writer);
            writer.flush();
            writer.close();
            System.out.println(name+" generated.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
