package org.java.test1;

public class DBEx {
	public static void main(String[] args) {
		try{
			DBConnector.getConnection();
			System.out.println("����̹��ε� ����");
			//DB�� ������ ��ȸ, ����, ����, �߰�
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			System.out.println("DB���� ����");
		}
	}
}
