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
		
		//Vector0번째 요소에 맴버를 초기화
		members.get(0).setUserId("m1");
		members.get(0).setUserPw("1111");
		members.get(0).setUserName("s1");
		members.get(0).setUserAge(11); //자동박싱
		
		//Vector0번째 요소의 맴버를 get
		String userId = members.get(0).getUserId();
		String userPw = members.get(0).getUserPw();
		String userName = members.get(0).getUserName();
		int userAge = members.get(0).getUserAge();
		
		System.out.println("아이디 : " + userId ); 
		System.out.println("비밀번호 : " + userPw); 
		System.out.println("이름 : " + userName); 
		System.out.println("나이 : " + userAge); 
		
		//members.get(1) 요소를 setters. getters 이용해서 각각필드를 모두 초기화
		//(임의의값)으로 하고 콘솔에 출력
		
		members.get(1).setUserId("user1");
		members.get(1).setUserPw("1111");
		members.get(1).setUserName("s2");
		members.get(1).setUserAge(12);
		
		System.out.println("아이디 : " + (members.get(1).getUserId()+"")); 
		System.out.println("비밀번호 : " + (members.get(1).getUserPw()+"")); 
		System.out.println("이름 : " + (members.get(1).getUserName()+"")); 
		System.out.println("나이 : " + (members.get(1).getUserAge()+""));
		
		
		
	} 	
}
