package org.java.exceptionEx;

public class ExceptionEx4 {
	public static void main(String[] args) {
		try {
			//1.����̹�
			Class.forName("con.mysql.cj.jdbc.Driver");
			System.out.println("����̹�OK");
		} catch (ClassNotFoundException e) {
			// 
			e.printStackTrace();
			System.out.println("����̹� NO");
		}finally {
			System.out.println("���ܻ������ ����");
		}
	} 
}