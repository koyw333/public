package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDAO.MemberDAO;

public class MemberDeleteDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ��Ż�� ������");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		String newUserID = request.getParameter("userID"); // ȸ��Ż�� �ؽ�Ʈ �ڽ��� �ִ� ID
		String newUserPW = request.getParameter("userPW"); // ȸ��Ż�� �ؽ�Ʈ �ڽ��� �ִ� PW
		
		HttpSession hs = request.getSession();
		
		String oldUserID = (String) hs.getAttribute("sessionID");
		String oldUserPW = (String) hs.getAttribute("sessionPW");
		
		if (newUserID.equals(oldUserID) && newUserPW.equals(oldUserPW)) {
			
			int rs = dao.delete(newUserID, newUserPW);
			
			if (rs == 1) {
				System.out.println("ȸ��Ż�� ����");
				hs.invalidate();
				request.setAttribute("url", "/index_login.jsp");
			} else {
				System.out.println("ȸ��Ż�� ����");
			}
			
		} else {
			
			System.out.println("���̵�� ��й�ȣ ��ġ���� ����");
			
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('���̵�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�')");
			script.println("history.back()");
			script.println("</script>");
			
		}
		
		
		
	}

}
