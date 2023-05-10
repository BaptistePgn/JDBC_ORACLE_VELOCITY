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

public class ProcedureGeneratorVelocity {
    // Generate all Packages procedures
    public static void generateAll() throws SQLError {
        try {
            OracleSession session = new OracleSession();
            Statement stmt = session.getConn().createStatement();
            ResultSet resultat = stmt.executeQuery( "SELECT DISTINCT OBJECT_NAME FROM user_procedures WHERE OBJECT_TYPE = 'PACKAGE'");
            while(resultat.next()) {
                String pn = resultat.getString("object_name");
                if (!pn.contains("$")) {
                    generate(pn);
                }
            }
            session.closeConn();
        } catch (SQLException e) {
            throw (new SQLError(e.getErrorCode(), e.getMessage()));
        }
    }
// Generate one Package procedures
    public static void generate(String namePackage) throws SQLError {
        try {
            OracleSession session = new OracleSession();
            VelocityContext context = new VelocityContext();
            List<Procedure> procedures = new ArrayList();
            Statement stmt = session.getConn().createStatement();

            // Get all procedures of the package
            ResultSet resultat = stmt.executeQuery( "SELECT * FROM user_procedures WHERE object_name ='" + namePackage + "' AND procedure_name IS NOT NULL");
            while(resultat.next()) {
                String procedure_name = resultat.getString("procedure_name");
                String type_retour = "boolean";

                // Get all parameters of the procedure
                List<Attribut> parametres = new ArrayList();
                Statement stmt2 = session.getConn().createStatement();
                ResultSet resultat2 = stmt2.executeQuery("SELECT * FROM user_arguments WHERE object_name ='" + procedure_name + "'AND package_name = '" + namePackage + "'");
                while (resultat2.next()) {
                    String argument_name = resultat2.getString("argument_name");
                    String data_type = sqlToJavaType(resultat2.getString("data_type"));
                    String in_out = resultat2.getString("in_out");
                    if (in_out.contains("OUT")){
                        type_retour = "String";
                    }
                    parametres.add(new Attribut(argument_name, data_type, in_out));
                }
                procedures.add(new Procedure(procedure_name, parametres, type_retour));
            }
            // Put the data in the context
            context.put("procedures", procedures);
            context.put("package", namePackage);
            context.put("import", "\n\n import java.util.ArrayList;" +
                    "\n import java.util.List;" +
                    "\n import bd.OracleSession;" +
                    "\n import java.sql.*;"+
                    "\n import java.math.BigDecimal;"+
                    "\n import oracle.jdbc.OracleTypes;"+
                    "\n import oracle.xdb.XMLType;"
            );
            save(namePackage + "DAO", context);
        } catch (SQLException e) {
            throw (new SQLError(e.getErrorCode(), e.getMessage()));
        }
    }
// Save the generated file
    private static void save(String name, VelocityContext context) {
        try {
            VelocityEngine ve = new VelocityEngine();
            Template t = ve.getTemplate( "./ressources/Procedure.vm" );
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
    // Convert SQL type to Java type
    public static String sqlToJavaType(String sqlType) {
        switch (sqlType) {
            case "VARCHAR2":
                return "String";
            case "NUMBER":
                return "BigDecimal";
            case "DATE":
                return "Timestamp";
            case "REF CURSOR":
                return "OracleTypes.CURSOR";
            case"VARRAY":
                    return "Array";
            default:
                return "String";
        }
    }
}
