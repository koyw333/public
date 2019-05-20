package org.java.memberController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request , response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text:html;charset=utf-8");
		
		//Ŭ���̾�Ʈ request������ �޴´�
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		//�������� Ŭ���̾�Ʈ���� ����(response)
		PrintWriter out =  response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>�α�������Ȯ��</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("���̵� : " + userId + " ");
		out.print("��й�ȣ: " + userPw + " ");
		out.print("</body>");
		
		out.print("</html>");
	}
	
}
