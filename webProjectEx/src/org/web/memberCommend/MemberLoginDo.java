package org.web.memberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.web.memberdao.MemberDao;

public class MemberLoginDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberDao dao = MemberDao.getInstance();
		System.out.println("�α���");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		

		
		int rs = dao.login(userId, userPw); // �α��� �����ϸ� 1
		
		HttpSession session = request.getSession();//���� ����
		
		if(rs==1) {
			session.setAttribute("sessionId", userId);
			session.setMaxInactiveInterval(60*10);
		}
	}

}
