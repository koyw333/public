package org.java.memberController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do") // *.do(������ �����ڰ� .do) ��� ����
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
		 
		 String uri = request.getRequestURI();		//��û URI
		 String path = request.getContextPath();	//�⺻ �н�
		 
		 String basicPath = uri.substring(path.length());
		 
		 System.out.println(uri);
		 System.out.println(path);
		 System.out.println(basicPath);
		 
		 
		 //if���� �̿��ؼ� basicPath "
		 PrintWriter out = response.getWriter();
		 
		 if(basicPath.equals("/login.do")) {
			 out.print("�α��� �������� �̵�");
		 }else if(basicPath.equals("/logOut.do")) { 
		 out.print("�α׾ƿ� �������� �̵�");
		 }else if(basicPath.equals("/joinMember.do")) { 
		 out.print("ȸ������ �������� �̵�");
		 }else if(basicPath.equals("/deleteMember.do")) { 
		 out.print("ȸ��Ż�� �������� �̵�");
		 }
		 
		 
		 out.close();
	 }
}
