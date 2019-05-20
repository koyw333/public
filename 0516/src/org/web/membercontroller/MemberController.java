package org.web.membercontroller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPoset");
		doaction(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		doaction(req, resp);
	}
	protected void doaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String userId = req.getParameter("userId");
		String userPw = req.getParameter("userPw");
		String userGender = req.getParameter("userGender");
		String guest = req.getParameter("guest");
		
		String[] hobbyArr = req.getParameterValues("hobboy");
		
		String hobbyStr="";
		
		for(String str:hobbyArr) {
			hobbyStr += str +",";
		}
		
		System.out.println(hobbyStr);
		hobbyStr = hobbyStr.substring(0, hobbyStr.length()-1);
		System.out.println(hobbyStr);

		}
}
