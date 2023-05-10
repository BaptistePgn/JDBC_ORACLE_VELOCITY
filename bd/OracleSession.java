package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleSession {
	
	private Connection conn;

	public OracleSession() throws SQLError {
		try {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		this.conn = DriverManager.getConnection("jdbc:oracle:thin:@172.26.82.31:1521:PDB1", "i10a07b", "i10a07b");
		} catch (SQLException e) {
			conn = null;
			throw (new SQLError(e.getErrorCode(), e.getMessage()));
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	public void closeConn() throws SQLError {
		try {
			conn.close();
		} catch (SQLException e) {
			throw (new SQLError(e.getErrorCode(), e.getMessage()));
		}
	}
	
}
