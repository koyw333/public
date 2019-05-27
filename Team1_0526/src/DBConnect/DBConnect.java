package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

	public static Connection getConnection() {
		
		Connection conn = null;
		DataSource dataSource;
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/team1");
			conn = dataSource.getConnection();
			
			System.out.println("Driver is connected");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return conn;
		
	}
	
}