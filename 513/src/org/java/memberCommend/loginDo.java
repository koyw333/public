package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class loginDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("로그인");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디 입력 : ");
		String userId = in.next();
		
		System.out.println("비밀번호 입력 : ");
		String userPw = in.next();
		
		MemberDAO dao = new MemberDAO();
		
		boolean bool = dao.login(userId, userPw);
		
		if(bool==true) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		
	}
	
}
