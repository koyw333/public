package org.web.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnect {

	public static Connection getConnection() {
		
		Connection conn=null;
		
		DataSource dataSource;
/*		
		String url="jdbc:mysql://localhost:3306/javaStudy?useSSL=false&serverTimezone=UTC";
		String user="root";
		String password="12345";
*/	
		try {
			// context 값(공용, 서버의 context.xml)
			Context context= new InitialContext();
			
			// type dataSource // 찾는다.JNDI
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/team1");
			
			conn =dataSource.getConnection();
			System.out.println("DBCP 연결 OK");
			
		}catch(Exception e){
			e.printStackTrace();
		}
/*			
			
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로드
			System.out.println("드라이버OK");

			conn=DriverManager.getConnection(url, user, password);//DB연결
			System.out.println("DB연결 OK");			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
*/		
		return conn;
	}
}
