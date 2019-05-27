package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDAO.MemberDAO;

public class MemberUpdateDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ�� ���� ���� ������");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession hs = request.getSession();
		
		String userID = (String) hs.getAttribute("sessionID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		int rs_name = dao.userNameCheck(userName);
		
		if (rs_name == 100) {
			
			System.out.println("ȸ������ ���� (�л��̸�����)");	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�л� �̸��� �����ϴ�')");
			script.println("history.back()");
			script.println("</script>");
			
		} else {
			
			int rs = dao.update(userID, userPW, userName, userEmail);
			
			if (rs == 1) {
				System.out.println("ȸ������ ����");
				/**** ȸ�� ������ ���������� session�� �ٲ� �� ������� ****/
				hs.setAttribute("sessionPW", userPW);
				hs.setAttribute("sessionName", userName);
				hs.setAttribute("sessionEmail", userEmail);
				/**********************************************/
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('ȸ�� ������ �����Ǿ����ϴ�')");
				script.println("location.href = 'index_login.jsp';");
				script.println("</script>");
			} else {
				System.out.println("ȸ������ ����!!!");
			}
				
			
			
			
		}
		
		
	}

}