package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class loginDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("�α���");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("���̵� �Է� : ");
		String userId = in.next();
		
		System.out.println("��й�ȣ �Է� : ");
		String userPw = in.next();
		
		MemberDAO dao = new MemberDAO();
		
		boolean bool = dao.login(userId, userPw);
		
		if(bool==true) {
			System.out.println("�α��� ����");
		}else {
			System.out.println("�α��� ����");
		}
		
		
	}
	
}
