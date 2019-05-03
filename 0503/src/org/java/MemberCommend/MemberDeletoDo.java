package org.java.MemberCommend;

import java.util.Scanner;

import org.java.MemberDAO.MemberDAO;

public class MemberDeletoDo implements MemberCommend {

	@Override
	public void excuteQueryCommend() {
		System.out.println("회원탈퇴");
		
		MemberDAO dao = new MemberDAO();
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디 입력 : ");
		String userId = in.next();
		System.out.println("비밀번호 입력 : ");
		String userPw = in.next();
		
		int result = dao.delete(userId, userPw);
		
		String url = "";
		
		//result 1 이면 "indext페이지로 이동"
		//result 0 이면 "회원탈퇴페이지로 이동"
		
		if(result == 1) {
			url = "index페이지로 이동";
		}else {
			url = "회원탈퇴 페이지로 이동";
		}

		System.out.println(url);
	}
}
