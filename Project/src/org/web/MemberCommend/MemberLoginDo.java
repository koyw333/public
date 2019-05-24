package org.web.MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.MemberDAO.MemberDAO;

public class MemberLoginDo implements QueryCommend {
	
	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("로그인 페이지");
		
		MemberDAO dao = MemberDAO.getInstance();

		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		System.out.println("getParameber pass");
		int rs = dao.Login(userId, userPw);
		System.out.println("userid,userpw");
		if (rs == 1) {
			System.out.println("로그인 성공");
			request.setAttribute("url", "LoginOK.jsp");
			
		} else if (rs == 2) {
			System.out.println("비밀번호 다름");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("history.back()");
			out.print("</script>");
		} 
	}

}
