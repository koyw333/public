package org.java.meberDTO;

import java.util.Vector;

public class VectorEx3 {
	public static void main(String[] args) {
		Vector<MemberDTO> members = new Vector<MemberDTO>();
		//MemberDTO m1 = new MemberDTO();

		members.add(new MemberDTO());
		members.add(new MemberDTO());
		members.add(new MemberDTO());
		members.add(new MemberDTO());
		members.add(new MemberDTO());
		members.add(new MemberDTO());
		
		//Vector0��° ��ҿ� �ɹ��� �ʱ�ȭ
		members.get(0).setUserId("m1");
		members.get(0).setUserPw("1111");
		members.get(0).setUserName("s1");
		members.get(0).setUserAge(11); //�ڵ��ڽ�
		
		//Vector0��° ����� �ɹ��� get
		String userId = members.get(0).getUserId();
		String userPw = members.get(0).getUserPw();
		String userName = members.get(0).getUserName();
		int userAge = members.get(0).getUserAge();
		
		System.out.println("���̵� : " + userId ); 
		System.out.println("��й�ȣ : " + userPw); 
		System.out.println("�̸� : " + userName); 
		System.out.println("���� : " + userAge); 
		
		//members.get(1) ��Ҹ� setters. getters �̿��ؼ� �����ʵ带 ��� �ʱ�ȭ
		//(�����ǰ�)���� �ϰ� �ֿܼ� ���
		
		members.get(1).setUserId("user1");
		members.get(1).setUserPw("1111");
		members.get(1).setUserName("s2");
		members.get(1).setUserAge(12);
		
		System.out.println("���̵� : " + (members.get(1).getUserId()+"")); 
		System.out.println("��й�ȣ : " + (members.get(1).getUserPw()+"")); 
		System.out.println("�̸� : " + (members.get(1).getUserName()+"")); 
		System.out.println("���� : " + (members.get(1).getUserAge()+""));
		
		
		
	} 	
}
