package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDAO.MemberDAO;

public class MemberUpdateDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("회원 정보 수정 페이지");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		HttpSession hs = request.getSession();
		
		String userID = (String) hs.getAttribute("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName");
		
		int rs_name = dao.userNameCheck(userName);
		
		if (rs_name == 100) {
			
			System.out.println("회원수정 실패 (학생이름없음)");	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('학생 이름이 없습니다')");
			script.println("history.back()");
			script.println("</script>");
			
		} else {
			
			String userEmail = request.getParameter("userEmail");
			
			if (userPW.equals("") || userName.equals("") || userEmail.equals("")) {
				
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력이 안 된 사항이 있습니다')");
				script.println("history.back()");
				script.println("</script>");
				
			} else {
				
				int rs = dao.update(userID, userPW, userName, userEmail);
				
				if (rs == 1) {
					System.out.println("회원수정 성공");
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('회원 정보가 수정되었습니다')");
					script.println("location.href = 'index_login.jsp';");
					script.println("</script>");
				} else {
					System.out.println("회원수정 실패!!!");
				}
				
			}
			
			
		}
		
		
	}

}
