package org.java.MemberCommend;
import java.util.ArrayList;
import java.util.Iterator;

import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberSelectDo implements MemberCommend {
	@Override
	public void excuteQueryCommend() {
		
		System.out.println("ȸ����ȸ : ");
		
		MemberDAO dao = new MemberDAO();
		
		dao.select();
		
		ArrayList<MemberDTO> lists = dao.select();
		
		//if�� ��� ��ȯ���� null �̸� db ������ ����
		//��ȯ���� null �ƴϸ� ArrayList������ Iterator�� �ܼ� ���
		
		if(lists == null) {
			System.out.println("ȸ�������� �����ϴ�.");
		}else {
			Iterator<MemberDTO> iterator = lists.iterator();
			while(iterator.hasNext()) {
				MemberDTO dto = iterator.next();
				System.out.println("���̵� : " + dto.getUserId());
				System.out.println("��й�ȣ : " + dto.getUserPw());
				System.out.println("�̸� : " + dto.getUserName());
				System.out.println("���� : " + dto.getUserAge());
			}
		}
	}
}
