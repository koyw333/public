package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class IdCheck implements QueryCommend{
	public void excuteCommend() {
		
	}

	@Override
	public void excuteQueryCommend() {
		
		System.out.println("아이디 체크");
		
		Scanner in = new Scanner(System.in);
		System.out.println("아이디 입력 : ");
		
		String userId = in.next();
		
		MemberDAO dao = new MemberDAO();
		boolean bool = dao.idCheck(userId);
		
		if(bool==false) {
			System.out.println("아이디가 존재하지 않는다."); // 회원가입 가능
		}else {
			System.out.println("중복된 아이디입니다.");
			System.out.println("아이디가 존재합니다.");	// 회원가입 불가
		}
		
	}
}
