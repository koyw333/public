package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDAO.MemberDAO;

public class MemberJoinDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ�� ����");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		int stuNum = dao.userNameCheck(userName);
		System.out.println(stuNum);
		
		if (stuNum == 100) {
			/************** �л� �̸��� �������� ���� �� ******************/
			System.out.println("ȸ������ ����");	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('�ش� �л��� �����ϴ�')");
			script.println("history.back()");
			script.println("</script>");
			/*********************************************/
		} else {
			
			int rs = dao.insert(userID, userPW, userName, userEmail);
			System.out.println(rs);
			
			if (rs == 1) {
				
				System.out.println("ȸ������ ����");
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('ȸ�����Կ� �����߽��ϴ�.');");
				script.println("location.href = 'index.jsp';");
				script.println("</script>");
				
			} 
			
		}
			
	}

}
