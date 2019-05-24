package MemberController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberCommend.MemberCheckPWDo;
import MemberCommend.MemberCheckedID;
import MemberCommend.MemberCheckedName;
import MemberCommend.MemberDeleteDo;
import MemberCommend.MemberJoinDo;
import MemberCommend.MemberListDo;
import MemberCommend.MemberLoginDo;
import MemberCommend.MemberUpdateDo;
import MemberCommend.QueryCommend;
import MemberDAO.MemberDAO;

@WebServlet("*.do")
public class MemberController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		/****** URI���� �ʿ��� �κи� ������ ���� ������ �����ϴ� �κ� ******/
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String uriFinal = uri.substring(path.length()+1, uri.length()-3);
		/*************************************************/

		// ��Ʈ�ѷ��� View(jsp) �������� request, response�� ����
		String url = "";
		
		QueryCommend action = null;
		
		if (uriFinal.equals("MemberJoin")) { // ȸ������
			action = new MemberJoinDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberList")){ // ȸ����ȸ
			action = new MemberListDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberLogin")) { // �α���
			action = new MemberLoginDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("CheckPW")) { // ȸ�� �����ϱ� ���� ��й�ȣ Ȯ��
			action = new MemberCheckPWDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberUpdate")) { // ȸ�� ����
			action = new MemberUpdateDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberCheckedID")) { // ���̵� üũ
			action = new MemberCheckedID();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberCheckedName")) { // �̸� üũ
			action = new MemberCheckedName();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		} else if (uriFinal.equals("MemberDelete")) {
			action = new MemberDeleteDo();
			action.excuteQueryCommend(request, response);
			url = (String) request.getAttribute("url");
		}
		
		else {
			System.out.println("��������");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // url(View) �������� request, response�� ����
		
	}
	
	
}