package org.java.memberCommend;
import java.util.ArrayList;
import java.util.Iterator;

import org.java.memberDAO.MemberDAO;
import org.java.memberDTO.memberDTO;

public class MemberSelectDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("ȸ����ȸ");
		
		MemberDAO dao = new MemberDAO();
		
		ArrayList<memberDTO> lists = dao.select();
		
		Iterator<Integer> iterator = 
		//iterator�� �ֿܼ� ���
		//���̵�, ��й�ȣ, �̸�, ���� 

		}
	}