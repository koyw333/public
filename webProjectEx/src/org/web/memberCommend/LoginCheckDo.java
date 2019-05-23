package org.web.memberCommend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.memberdao.MemberDao;

public class LoginCheckDo implements MemberCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("아이디 체크");
		
		String userId = request.getParameter("userId");
		
		MemberDao dao = MemberDao.getInstance();
		
		int rs = dao.idChecked(userId);
		
		
		if(rs==1) {
			System.out.println("중복아이디");
		}else {
			System.out.println("사용할 수 있는 아이디");
			
			request.setAttribute("userId", userId);//입력 아이디
			request.setAttribute("OkChecked", "OkChecked");//아이디 체크 유무
		}
		
		request.setAttribute("rs", rs);    //1,0
		request.setAttribute("url", "idchecked.jsp");
		
	}

}
