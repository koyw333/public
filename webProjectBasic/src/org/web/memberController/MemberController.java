package org.web.memberController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberCommend.MemberCommend;
import org.web.memberCommend.MemberJoinDo;

@WebServlet("*.do")
public class MemberController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI(); //  Path/JOIN.do
		String path=request.getContextPath();//서버 기본 Path		
		String basicURL=uri.substring(path.length());
		
		System.out.println(uri);
		System.out.println(path);
		
		
		String url="";// 컨트롤러가 View(jsp)페이지로 request,response를 전송
		
		MemberCommend action=null;
		
		
		if(basicURL.equals("/JOIN.do")) {
			action=new MemberJoinDo();
			action.excuteQueryCommend(request, response);			
			url=(String)request.getAttribute("url");//Commend에서 반환 대는 url
			
		}else if(basicURL.equals("/Update.do")) {
			
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);// url(View)페이지로 request,response를 전송
		
		
			
		
		
		
	}
	
	
}
