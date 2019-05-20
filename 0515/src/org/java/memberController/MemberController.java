package org.java.memberController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") // *.do(마지막 세글자가 .do) 라면 실행
public class MemberController extends HttpServlet{

	
	
	
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
	 
	 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPoset");
		doAction(request, response);
	}
	 
	 protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=utf-8");
		 
		 String uri = request.getRequestURI();		//요청 URI
		 String path = request.getContextPath();	//기본 패스
		 
		 String basicPath = uri.substring(path.length());
		 
		 System.out.println(uri);
		 System.out.println(path);
		 System.out.println(basicPath);
		 
		 
		 //if문을 이용해서 basicPath "
		 PrintWriter out = response.getWriter();
		 
		 if(basicPath.equals("/login.do")) {
			 out.print("로그인 페이지로 이동");
		 }else if(basicPath.equals("/logOut.do")) { 
		 out.print("로그아웃 페이지로 이동");
		 }else if(basicPath.equals("/joinMember.do")) { 
		 out.print("회원가입 페이지로 이동");
		 }else if(basicPath.equals("/deleteMember.do")) { 
		 out.print("회원탈퇴 페이지로 이동");
		 }
		 
		 
		 out.close();
	 }
}
