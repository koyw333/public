package org.web.MemberCommend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.MemberDAO.MemberDAO;
import org.web.MemberDTO.MemberDTO;

public class MemberListDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ȸ����ȸ");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		ArrayList<MemberDTO> memberLists = dao.Member_List();
		
		// DB ������
		request.setAttribute("memberLists", memberLists);
		System.out.println("DAO -> DB data");
		
		// URL
		request.setAttribute("url", "/MemberList.jsp");
		System.out.println("Show the MemberList.jsp");
		
	}

}
