package org.java.collectionEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.java.MemberDTO.MemberDTO;

public class MapEx3 {
	public static void main(String[] args) {
			//key, value
		
		Map<Integer, MemberDTO> map1 = new HashMap<Integer, MemberDTO>();
			new HashMap<Integer, MemberDTO>();
			//put
			map1.put(1, new MemberDTO("m1", "11", "s1", 11));
			map1.put(2, new MemberDTO("m2", "21", "s2", 21));
			map1.put(3, new MemberDTO("m3", "31", "s3", 31));
			map1.put(4, new MemberDTO("m4", "41", "s4", 41));
			map1.put(5, new MemberDTO("m5", "51", "s5", 51));
			
			
			// map 키값만 set으로 저장
			Set<Integer> set1 = map1.keySet();
			
			// keySet "Map 키값을 저장하는 Set" >> Iterator
			Iterator<Integer> iterator = set1.iterator(); 
			
			//while문으로 출력
			while(iterator.hasNext()) {
				Integer key = iterator.next();//key
				MemberDTO dto = map1.get(key); //key를 이용해 객체를 get
				System.out.println("아이디 : " + dto.getUserId()+ " ");
				System.out.println("비밀번호 : " + dto.getUserPw()+ " ");
				System.out.println("이름 : " + dto.getUserName()+ " ");
				System.out.println("나이 : " + dto.getUserAge()+ " ");
				
			}
	}
}