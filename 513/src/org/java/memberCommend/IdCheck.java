package org.java.memberCommend;

import java.util.Scanner;

import org.java.memberDAO.MemberDAO;

public class IdCheck implements QueryCommend{
	public void excuteCommend() {
		
	}

	@Override
	public void excuteQueryCommend() {
		
		System.out.println("���̵� üũ");
		
		Scanner in = new Scanner(System.in);
		System.out.println("���̵� �Է� : ");
		
		String userId = in.next();
		
		MemberDAO dao = new MemberDAO();
		boolean bool = dao.idCheck(userId);
		
		if(bool==false) {
			System.out.println("���̵� �������� �ʴ´�."); // ȸ������ ����
		}else {
			System.out.println("�ߺ��� ���̵��Դϴ�.");
			System.out.println("���̵� �����մϴ�.");	// ȸ������ �Ұ�
		}
		
	}
}
