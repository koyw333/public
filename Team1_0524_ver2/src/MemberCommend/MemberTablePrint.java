package MemberCommend;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import MemberDAO.MemberDAO;

public class MemberTablePrint implements QueryCommend{

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = MemberDAO.getInstance();
		String query = "select * from student1";
		
		PreparedStatement  = 
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
