package org.java.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/member?userSSL=false&serverTimezone=UTC";
		String user = "root";
		String password = "12345";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
}
