package org.java.MemberCommend;

import java.util.Scanner;

import org.java.MemberDAO.MemberDAO;

public class MemberDeletoDo implements MemberCommend {

	@Override
	public void excuteQueryCommend() {
		System.out.println("ȸ��Ż��");
		
		MemberDAO dao = new MemberDAO();
		Scanner in = new Scanner(System.in);
		
		System.out.println("���̵� �Է� : ");
		String userId = in.next();
		System.out.println("��й�ȣ �Է� : ");
		String userPw = in.next();
		
		int result = dao.delete(userId, userPw);
		
		String url = "";
		
		//result 1 �̸� "indext�������� �̵�"
		//result 0 �̸� "ȸ��Ż���������� �̵�"
		
		if(result == 1) {
			url = "index�������� �̵�";
		}else {
			url = "ȸ��Ż�� �������� �̵�";
		}

		System.out.println(url);
	}
}
