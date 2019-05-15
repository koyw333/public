package org.web.MemberController;

import java.io.IOException;

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
				
				System.out.println(uri);
				System.out.println(path);
			}
		
}