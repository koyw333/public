package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class MemberInsertDo implements QueryCommend {

	@Override
	public void excuteQueryCommend() {
		System.out.println("회원가입");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디 입력 : ");
		String userId = in.next();
		
		System.out.println("비밀번호 입력 : ");
		String userPw = in.next();

		System.out.println("이름 입력 : ");
		String userName = in.next();
		
		System.out.println("나이 입력 : ");
		int userAge = in.nextInt();
		
		MemberDAO dao = new MemberDAO();
		
		int rs = dao.insert(userId, userPw, userName, userAge);
		
		if(rs==1) {
			System.out.println("회원가입 성공.. 로그인페이지로 이동");
		}else {
			System.out.println("회원가입 실패");
		}
		
	}
	
}
