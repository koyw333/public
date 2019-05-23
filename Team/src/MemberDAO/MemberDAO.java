package MemberDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnect.DBConnect;
import MemberDTO.MemberDTO;

public class MemberDAO {

	private static final MemberDAO dao = new MemberDAO();
	private static Connection conn = null;
	
	public MemberDAO() {}
	
	public static MemberDAO getInstance() {
		
		return MemberDAO.dao;
	}
	
	public int insert(String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		// SQL 처리
		// 밑에 query에 query문 작성할 때 ? 부분에 값들을 자동으로 집어넣어주는 역할해주는놈
		PreparedStatement pstm = null;
		// 실제 쿼리문
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "insert into joinTest(userID, userPW, userName, userEmail) " +
				"values(?,?,?,?);";
		
		try {
			// 실제 쿼리문
			
			// SQL 처리 ( ?에 value 담아주기 )
			pstm = conn.prepareStatement(query); // PreparedStatement에 저장
			
			pstm.setString(1, userID);
			pstm.setString(2, userPW);
			pstm.setString(3, userName);
			pstm.setString(4, userEmail);
			
			
			// 실행
			rs = pstm.executeUpdate(); // 조회, 수정, 탈퇴.... 리턴값이 1이면 성공 0이면 실패
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					
					if (conn != null) conn.close();	
					if (pstm != null) pstm.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {	}
				
		}		
	
		return -1;
		
	}
	
	public ArrayList<MemberDTO> Member_List() {
		
		ArrayList<MemberDTO> lists = new ArrayList<MemberDTO>();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery(); // 조회, DB데이터 get
			
			while (rs.next()) {
				
				lists.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
	
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {}
			
		}
		
		return lists;
		
	}
	
	/********************* 회원가입 - 이름체크 **************************/
	public int userNameCheck (String userName) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		/************************** 학생 명단 비교 *******************************/
		String[] stuNameLists = {"고준혁","곽현석","권상욱","김범필","김태욱","복승현","성지훈","신수경",
					"우주희","유동희","윤종민","임은수","장진열","정주현","정진호","조수민","조창우","홍인기"};
		
		int temp = 0;
		
		for (int i = 0; i < stuNameLists.length; i++) {
			if (stuNameLists[i].equals(userName))
				temp = i;
		}
		
		// 배열 인덱스는 0부터 시작, 학생 테이블에서 번호는 1부터 시작하기 때문에 1을 더해줘야함
		if (temp > 0)
			temp++;
		/**********************************************************************/
		
		conn = DBConnect.getConnection();
		String query = "select * from students where stuNum = " + temp + ";";
		
		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.println("이름찾기 성공");
				return Integer.parseInt(rs.getString(1));
			}
			
			return 100; // 이름이 없는 경우
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -2; // 데이터베이스 오류
		
	}
	/*********************************************************/
	
	
	public int login (String userID, String userPW, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		String userName, userEmail; // Session에 집어넣을 이름과 이메일
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // 조회, DB데이터 get
			
			if (rs.next()) {
				
				if (rs.getString(2).equals(userPW)) {

					userName = rs.getString(3);
					userEmail = rs.getString(4);
					
					HttpSession hs = request.getSession();
					hs.setAttribute("userID", userID);
					hs.setAttribute("userPW", userPW);
					hs.setAttribute("userName", userName);
					hs.setAttribute("userEmail", userEmail);
					
					return 1; // 로그인 성공
					
				} else {
					return 2; // 비밀번호 틀림
				}
				
			}
			
			return 3; // 아이디 없음
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -2; // 데이터베이스 오류
	}
	
	
}