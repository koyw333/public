package org.java.MemberCommend;
import java.util.Scanner;
import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberUpdateDo implements MemberCommend{
	@Override
	public void excuteQueryCommend() {
		System.out.println("회원수정 : ");
		//로그인 이후 DB아이디로 수정(Session 이용)
		// 데이터를 get 한 후에 수정
		
		MemberDAO dao = new MemberDAO();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("아이디 입력");
		String userId = in.next();
		
		MemberDTO list = dao.member(userId);
		
		if(list!=null) {
			System.out.println("회원수정 작업 진행");
		}else {
			System.out.println("회원수정 작업 실패"); 
		}
		
		
	}
}
