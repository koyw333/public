package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDAO.MemberDAO;

public class MemberLoginDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("�α��� ������");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		int rs = dao.login(userID, userPW, request, response);
		
		if (rs == 1) {
			System.out.println("�α��� ����");
			request.setAttribute("url", "/index_login.jsp");
		} else if (rs == 2) {
			System.out.println("��й�ȣ �ٸ�");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('Ʋ�� ��й�ȣ�Դϴ�')");
			script.println("history.back()");
			script.println("</script>");
		} else if (rs == 3) {
			System.out.println("���̵� ����");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('���� ���̵��Դϴ�')");
			script.println("history.back()");
			script.println("</script>");
		}
		
	}

}
