package org.java.MemberCommend;

import java.util.Scanner;

import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberInsertDo implements MemberCommend{
	@Override
	public void excuteQueryCommend() {
		System.out.println("ȸ������");
		
		MemberDAO dao = new MemberDAO();
		Scanner in = new Scanner(System.in);
		System.out.println("���̵� �Է� : ");
		String userId = in.next();
		System.out.println("��й�ȣ �Է� : ");
		String userPw = in.next();
		System.out.println("�̸� �Է� : ");
		String userName = in.next();
		System.out.println("���� �Է� : ");
		int userAge = in.nextInt();
		
		MemberDTO dto = new MemberDTO(userId, userPw, userName, userAge);
		
		dao.insert(dto);
		
	}
}
