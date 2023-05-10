package dao;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import bean.Attribut;

import bd.OracleSession;
import bd.SQLError;

public class BeanGeneratorVelocity {
	
	
	// Generate all tables
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
   // Generate one table
	public static void generate(String table) throws SQLError {
		try {
			OracleSession session = new OracleSession();
			VelocityContext context = new VelocityContext();
			
			String tn = table.substring(0, 1) + table.substring(1).toLowerCase();
			
			ArrayList<Attribut> list= new ArrayList<Attribut>();
		    context.put("Table", tn);
			
			Statement stmt = session.getConn().createStatement();
			// Get all columns
			ResultSet resultat = stmt.executeQuery("SELECT * FROM "+table);
			ResultSetMetaData rsmd = resultat.getMetaData();
			for (int i = 1 ; i <= rsmd.getColumnCount() ; i++) {
				String cn = rsmd.getColumnName(i);
				Attribut a = new Attribut(cn, rsmd.getColumnClassName(i));
				list.add(a);
			}
			// Put the data in the context
			context.put("import", "");
			context.put("AttributsList", list);
		    
		    save(tn, context);
		    
		} catch (SQLException e) {
			throw (new SQLError(e.getErrorCode(), e.getMessage()));
		}
	}
	// Save the generated file
	private static void save(String name, VelocityContext context) {
		try {
			VelocityEngine ve = new VelocityEngine();
			Template t = ve.getTemplate( "./ressources/Table.vm" );
			File file= new File("./bean/"+name+".java");
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
