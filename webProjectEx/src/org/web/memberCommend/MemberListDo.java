package org.web.memberCommend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.MemeberDto.MemberDto;
import org.web.memberdao.MemberDao;

public class MemberListDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원조회");
		
		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> members = dao.members();
				
		//DB데이터
		request.setAttribute("members", members);
		
		//URL
		request.setAttribute("url", "MemberList.jsp");
		
	}

}
