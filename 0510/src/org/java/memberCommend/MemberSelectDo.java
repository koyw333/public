package org.java.memberCommend;
import java.util.ArrayList;
import java.util.Iterator;

import org.java.memberDAO.MemberDAO;
import org.java.memberDTO.memberDTO;

public class MemberSelectDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("회원조회");
		
		MemberDAO dao = new MemberDAO();
		
		ArrayList<memberDTO> lists = dao.select();
		
		Iterator<Integer> iterator = 
		//iterator로 콘솔에 출력
		//아이디, 비밀번호, 이름, 나이 

		}
	}