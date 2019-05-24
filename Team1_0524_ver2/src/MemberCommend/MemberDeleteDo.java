package MemberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDAO.MemberDAO;

public class MemberDeleteDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ��Ż�� ������");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		int rs = dao.delete(userID, userPW);
		
		if (rs == 1) {
			System.out.println("ȸ��Ż�� ����");
			request.setAttribute("url", "/index_login.jsp");
		} else {
			System.out.println("ȸ��Ż�� ����");
		}
		
	}

}
