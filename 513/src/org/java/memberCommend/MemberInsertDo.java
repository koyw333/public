package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class MemberInsertDo implements QueryCommend {

	@Override
	public void excuteQueryCommend() {
		System.out.println("ȸ������");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("���̵� �Է� : ");
		String userId = in.next();
		
		System.out.println("��й�ȣ �Է� : ");
		String userPw = in.next();

		System.out.println("�̸� �Է� : ");
		String userName = in.next();
		
		System.out.println("���� �Է� : ");
		int userAge = in.nextInt();
		
		MemberDAO dao = new MemberDAO();
		
		int rs = dao.insert(userId, userPw, userName, userAge);
		
		if(rs==1) {
			System.out.println("ȸ������ ����.. �α����������� �̵�");
		}else {
			System.out.println("ȸ������ ����");
		}
		
	}
	
}