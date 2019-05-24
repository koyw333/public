package org.web.memberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			System.out.println("로그아웃");
			
			HttpSession session = request.getSession();
			
			session.invalidate();//세션제거
			request.setAttribute("url", "/Index.jsp");
		
	}

	
}
