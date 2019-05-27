package MemberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberDAO.MemberDAO;

public class MemberCheckedID implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("���̵� üũ");
		
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int rs = dao.idCheck(userID);
		
		System.out.println(userName);
		
		// ���̵� üũ�� ��� setAtrribute�� ����
		// rs + ""�ѰŴ� rs�� int���̶� String���� �ٲ��ֱ� ���Ѱ�
		request.setAttribute("resultAfterIDCheck", rs + "");
		
		if (rs == 1) {
			System.out.println("�ߺ����̵�");
		} else {
			System.out.println("����� �� �ִ� ���̵�");
			request.setAttribute("userID", userID);
			request.setAttribute("userName", userName);
			request.setAttribute("userEmail", userEmail);
			request.setAttribute("Checked", "Checked");
		}
		
		request.setAttribute("url", "/idChecked.jsp");
		
	}

}
