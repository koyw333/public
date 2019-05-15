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
	
	//post 형식으로 전송
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("dopost");
		doAction(request, response);
	}
	

	//get 형식으로 전송
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doAction(request, response);
	}
	
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				request.setCharacterEncoding("utf-8");  				//클라이언트의 문자열
				response.setContentType("text/html;charset=utf-8");		//서버가 응답하는 타입
				
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
				
				PrintWriter out = response.getWriter(); // 서버에서 클라이언트 응답
				
				out.print("<html>");
				out.print("<head>");
				out.print("<title>서버에서응답</title>");
				out.print("</head>");
				out.print("<body>");
				out.print("아이디 : " + userId+ ", ");
				out.print("비밀번호 : " + userPw+ ", ");
				out.print("이름 : " + userName+ ", ");
				out.print("나이 : " + userAge+ ", ");
				
				out.print("</body>");
				out.print("</html>");
				
				out.close();
			}
		
}