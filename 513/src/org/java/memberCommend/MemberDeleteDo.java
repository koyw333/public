package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class MemberDeleteDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("회원삭제");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디 입력 : ");
		String userId = in.next();

		
		MemberDAO dao = new MemberDAO();
		
		int rs = dao.delete(userId);
		
		if(rs==1) {
			System.out.println("회원탈퇴 성공");
		}else {
			System.out.println("회원탈퇴 실패");
		}
	}
}