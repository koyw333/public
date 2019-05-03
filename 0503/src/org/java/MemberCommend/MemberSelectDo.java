package org.java.MemberCommend;
import java.util.ArrayList;
import java.util.Iterator;

import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberSelectDo implements MemberCommend {
	@Override
	public void excuteQueryCommend() {
		
		System.out.println("회원조회 : ");
		
		MemberDAO dao = new MemberDAO();
		
		dao.select();
		
		ArrayList<MemberDTO> lists = dao.select();
		
		//if문 사용 반환값이 null 이면 db 정보가 없고
		//반환값이 null 아니면 ArrayList정보를 Iterator로 콘솔 출력
		
		if(lists == null) {
			System.out.println("회원정보가 없습니다.");
		}else {
			Iterator<MemberDTO> iterator = lists.iterator();
			while(iterator.hasNext()) {
				MemberDTO dto = iterator.next();
				System.out.println("아이디 : " + dto.getUserId());
				System.out.println("비밀번호 : " + dto.getUserPw());
				System.out.println("이름 : " + dto.getUserName());
				System.out.println("나이 : " + dto.getUserAge());
			}
		}
	}
}
