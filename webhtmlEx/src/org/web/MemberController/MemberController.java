package org.web.MemberController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memberJoin.do")
public class MemberController extends HttpServlet{
	
	//post �������� ����
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("dopost");
		doAction(request, response);
	}
	

	//get �������� ����
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doAction(request, response);
	}
	
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				request.setCharacterEncoding("utf-8");  				//Ŭ���̾�Ʈ�� ���ڿ�
				response.setContentType("text/html;charset=utf-8");		//������ �����ϴ� Ÿ��
				
				String uri = request.getRequestURI();
				String path = request.getContextPath();
				
				String userId = request.getParameter("userId"); 
				String userPw = request.getParameter("userPw"); 
				String userName = request.getParameter("userName"); 
				String userAge = request.getParameter("userAge"); 
				
				System.out.println(userId);
				System.out.println(userPw);
				System.out.println(userName);
				System.out.println(userAge);
				
				System.out.println(uri);
				System.out.println(path);
				
				PrintWriter out = response.getWriter(); // �������� Ŭ���̾�Ʈ ����
				
				out.print("<html>");
				out.print("<head>");
				out.print("<title>������������</title>");
				out.print("</head>");
				out.print("<body>");
				out.print("���̵� : " + userId+ ", ");
				out.print("��й�ȣ : " + userPw+ ", ");
				out.print("�̸� : " + userName+ ", ");
				out.print("���� : " + userAge+ ", ");
				
				out.print("</body>");
				out.print("</html>");
				
				out.close();
			}
		
}