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
		//members 각기의 요소를 출력 for문
		
		for(int i=0; i<members.size(); i++) {
			System.out.println("아이디" + members.get(i).getUserId()+"");
			System.out.println("비밀번호" + members.get(i).getUserPw()+"");
			System.out.println("이름" + members.get(i).getUserName()+"");
			System.out.println("나이" + members.get(i).getUserAge()+"");
		}
		
		//members 각기의 요소를 foreach문으로 출력
		for(MemberDTO dto:members) { 
			System.out.print("아이디 : "+dto.getUserId()+ "");
			System.out.print("비밀번호 : "+dto.getUserPw()+ "");
			System.out.print("이름 : "+dto.getUserName()+ "");
			System.out.print("나이 : "+dto.getUserAge()+ "");
			
		}
	}
}
