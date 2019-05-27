package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDAO.MemberDAO;

public class MemberCheckPWDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ�� ���� ���� ��й�ȣ Ȯ��");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession hs = request.getSession();
		
		String userID = (String) hs.getAttribute("sessionID");
		String userPW = request.getParameter("userPW");
		
		int rs = dao.checkPW(userID, userPW);
		
		if (rs == 1) { // ��й�ȣ�� ��ġ�ϸ�
			request.setAttribute("url", "/MemberUpdate.jsp");
			System.out.println("��й�ȣ ��ġ");
		} else {
			System.out.println("��й�ȣ �ٸ�");
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('Ʋ�� ��й�ȣ�Դϴ�')");
			script.println("history.back()");
			script.println("</script>");
		}
		
	}

}
