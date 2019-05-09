package org.java.test1;
import java.sql.Connection;

public class DBConnector {
	public static void getConnection() throws ClassNotFoundException {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
	}
}
