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

			System.out.println("�α׾ƿ�");
			
			HttpSession session = request.getSession();
			
			session.invalidate();//��������
			request.setAttribute("url", "/Index.jsp");
		
	}

	
}
