package org.java.test1;

public class DBEx {
	public static void main(String[] args) {
		try{
			DBConnector.getConnection();
			System.out.println("드라이버로드 성공");
			//DB에 접근해 조회, 삭제, 수정, 추가
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			System.out.println("DB연동 종료");
		}
	}
}
