package org.java.MemberCommend;

import java.util.Scanner;

import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberInsertDo implements MemberCommend{
	@Override
	public void excuteQueryCommend() {
		System.out.println("회원가입");
		
		MemberDAO dao = new MemberDAO();
		Scanner in = new Scanner(System.in);
		System.out.println("아이디 입력 : ");
		String userId = in.next();
		System.out.println("비밀번호 입력 : ");
		String userPw = in.next();
		System.out.println("이름 입력 : ");
		String userName = in.next();
		System.out.println("나이 입력 : ");
		int userAge = in.nextInt();
		
		MemberDTO dto = new MemberDTO(userId, userPw, userName, userAge);
		
		dao.insert(dto);
		
	}
}
