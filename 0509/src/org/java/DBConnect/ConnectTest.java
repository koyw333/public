package org.java.DBConnect;

public class ConnectTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����̹� NO");
		} finally {
			System.out.println("DB����");
		}
	}
}
