package org.web.MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.MemberDAO.MemberDAO;

public class MemberJoinDo implements QueryCommend, MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("회원 가입");

		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤 호출
		int rs = dao.insert(userId, userPw, userName, userEmail);
		
		String url="";
		
		if(rs==1) {
			System.out.println("성공");
			url ="/Index.jsp";
		}else if(rs!=1){
			System.out.println("실패");
			url ="/Index.jsp";
		}
		request.setAttribute("url", url);
	}

}
