package org.web.MemberController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.MemberCommend.MemberCommend;
import org.web.MemberCommend.MemberJoinDo;
import org.web.MemberCommend.MemberListDo;
import org.web.MemberCommend.MemberLoginDo;
import org.web.MemberCommend.QueryCommend;
import org.web.MemberDAO.MemberDAO;

@WebServlet("*.do")
public class MemberController extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request,response);
    }
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        
    	
    	
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String uriFinal = uri.substring(path.length()+1, uri.length()-3);
        
    
        
        String url="";// 컨트롤러가 View(jsp)페이지로 request,response를 전송
        
        QueryCommend action=null;
        
        
		if (uriFinal.equals("MemberJoin")) {
			action = new MemberJoinDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberList")){
			action = new MemberListDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberLogin")) {
			action = new MemberLoginDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
			System.out.println("Controller Pass");
		} else {
			System.out.println("error");
		}
        
        RequestDispatcher dispatcher=request.getRequestDispatcher(url);
        dispatcher.forward(request, response);// url(View)페이지로 request,response를 전송
        
        
    }
}