package org.java.memberCommend;
import java.util.Scanner;
import org.java.memberDAO.MemberDAO;

public class MemberUpdateDo implements QueryCommend{

	@Override
	public void excuteQueryCommend() {
		System.out.println("회원수정");
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("비밀번호 입력 : ");
		String userPw = in.next();

		System.out.println("이름 입력 : ");
		String userName = in.next();
		
		System.out.println("나이 입력 : ");
		int userAge = in.nextInt();
		
		System.out.println("아이디 입력 : ");
		String userId = in.next();
		
		MemberDAO dao = new MemberDAO();
		
		int rs = dao.update(userPw, userName, userAge, userId);
		
		if(rs==1) {
			System.out.println("회원수정 성공");
		}else {
			System.out.println("회원수정 실패");
		}
		
	}

}
