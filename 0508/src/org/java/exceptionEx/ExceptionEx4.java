package org.java.exceptionEx;

public class ExceptionEx4 {
	public static void main(String[] args) {
		try {
			//1.드라이버
			Class.forName("con.mysql.cj.jdbc.Driver");
			System.out.println("드라이버OK");
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
			System.out.println("드라이버 NO");
		}finally {
			System.out.println("예외상관없이 실행");
		}
	} 
}