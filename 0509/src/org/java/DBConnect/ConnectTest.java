package org.java.DBConnect;

public class ConnectTest {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 OK");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 NO");
		} finally {
			System.out.println("DB종료");
		}
	}
}
