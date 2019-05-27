package org.web.memberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberDTO.MemberDTO;
import org.web.memberdao.MemberDao;

public class MemberModifyViewDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원 조회");
		
		String userId = request.getParameter("userId");
		
		MemberDao dao = MemberDao.getInstance();
				
		MemberDTO member = dao.memberView(userId);
		
		String url = "";
		
		if(member==null) {
			System.out.println("조회 데이터가 없다.");
		}else {
			request.setAttribute("member", member);
			System.out.println("조회 데이터 있음");
			url = "MemberView.jsp";
		}
		request.setAttribute("url", url);	
	}
}