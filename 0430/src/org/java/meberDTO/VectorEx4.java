package org.java.meberDTO;

import java.util.Vector;

public class VectorEx4 {
	public static void main(String[] args) {
		Vector<MemberDTO> members = new Vector<MemberDTO>();
		
		members.add(new MemberDTO("m1", "11", "s1", 11));
		members.add(new MemberDTO("m2", "21", "s2", 21));
		members.add(new MemberDTO("m3", "31", "s3", 31));
		members.add(new MemberDTO("m4", "41", "s4", 41));
		members.add(new MemberDTO("m5", "51", "s5", 51));
		
		System.out.println(members.size());
		//members ������ ��Ҹ� ��� for��
		
		for(int i=0; i<members.size(); i++) {
			System.out.println("���̵�" + members.get(i).getUserId()+"");
			System.out.println("��й�ȣ" + members.get(i).getUserPw()+"");
			System.out.println("�̸�" + members.get(i).getUserName()+"");
			System.out.println("����" + members.get(i).getUserAge()+"");
		}
		
		//members ������ ��Ҹ� foreach������ ���
		for(MemberDTO dto:members) { 
			System.out.print("���̵� : "+dto.getUserId()+ "");
			System.out.print("��й�ȣ : "+dto.getUserPw()+ "");
			System.out.print("�̸� : "+dto.getUserName()+ "");
			System.out.print("���� : "+dto.getUserAge()+ "");
			
		}
	}
}
