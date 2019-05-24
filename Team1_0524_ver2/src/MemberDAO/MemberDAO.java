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
	
	/****************************** 회원가입 ****************************************/
	public int insert(String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		// SQL 처리
		// 밑에 query에 query문 작성할 때 ? 부분에 값들을 자동으로 집어넣어주는 역할해주는놈
		PreparedStatement pstm = null;
		// 실제 쿼리문
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "insert into joinTest values(?,?,?,?);";
		
		try {
			// 실제 쿼리문
			
			// SQL 처리 ( ?에 value 담아주기 )
			pstm = conn.prepareStatement(query); // PreparedStatement에 저장
			
			pstm.setString(1, userID.trim());
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
	/***************************************************************************/
	
	/**************************** 회원 조회 ********************************/
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
	/***************************************************************************/
	/***************************** 회원가입 - 이름체크 *************************************/
	public int userNameCheck (String userName) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		/************************** 학생 명단 비교 *******************************/
		String[] stuNameLists = {"고준혁","곽현석","권상욱","김범필","김태욱","복승현","성지훈","신수경",
					"우주희","유동희","윤종민","임은수","장진열","정주현","정진호","조수민","조창우","홍인기"};
		
		int temp = -1;
		
		for (int i = 0; i < stuNameLists.length; i++) {
			if (stuNameLists[i].equals(userName))
				temp = i;
		}
		
		// 배열 인덱스는 0부터 시작, 학생 테이블에서 번호는 1부터 시작하기 때문에 1을 더해줘야함
		if (temp > -1)
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
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return -2; // 데이터베이스 오류
		
	}
	/********************************************************************************************/
	
	/******************************************* 로그인 *****************************************/
	public int login (String userID, String userPW, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		String userName, userEmail;
		HttpSession hs = request.getSession();
		
		try {
			
			System.out.println("빌어먹을 아이디 : " + userID);
			System.out.println("빌어먹을 비밀번호 : " + userPW);
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // 조회, DB데이터 get
			
			if (rs.next()) {
				
				System.out.println("들어왔당1");
				
				if (rs.getString(2).equals(userPW)) {
					
					userName = rs.getString(3);
					userEmail = rs.getString(4);
					
					hs.setAttribute("sessionID", userID);
					hs.setAttribute("sessionPW", userPW);
					hs.setAttribute("sessionName", userName);
					hs.setAttribute("sessionEmail", userEmail);
					
					return 1; // 로그인 성공
					
				} else {
					return 2; // 비밀번호 틀림
				}
				
			}
			
			return 3; // 아이디 없음
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return -2; // 데이터베이스 오류
	}
	/****************************************************************************************/
	/*************************** 비밀번호 일치하는지 확인 (회원수정창에 들어가기전) ****************************/
	public int checkPW (String userID, String userPW) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // 조회, DB데이터 get
			
			if (rs.next()) {
				if (rs.getString(2).equals(userPW)) return 1; // 비밀번호 일치
				else return 2; // 비밀번호 불일치
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
			} finally {	}
			
		}	
		
		return -2;
		
	}
	/********************************************************************************************/
	/********************************* 회원수정 *****************************/
	public int update (String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		PreparedStatement pstm = null;
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "update joinTest set userPW = ?, userName = ?, userEmail = ? where userID = ?;";
		
		try {
			System.out.println("회원수정 ㄱㄱ");
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userPW);
			pstm.setString(2, userName);
			pstm.setString(3, userEmail);
			pstm.setString(4, userID);
			
			rs = pstm.executeUpdate();
			System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return rs;
		
	}
	/*********************************************************************/
	/**************************** ID 체크 *******************************/
	public int idCheck (String userID) {
		

		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		
		conn = DBConnect.getConnection();
		query = "select count(*) from joinTest where userID = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}
		
		return -2; // 데이터베이스 오류
		
	}
	/******************************************************************/
	/************************ 회원 삭제 ****************************/
	public int delete (String userID, String userPW) {
		
		int rs = 0;
		
		PreparedStatement pstm = null;
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "delete from joinTest where userID = ? and userPW = ?";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			pstm.setString(2, userPW);
			rs = pstm.executeUpdate();
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (conn != null) conn.close();
				if (pstm != null) pstm.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {}
		}
		
		return -2;
		
	}
	/************************************************************/
	/************************************************************/
	// 회원 테이블 불러오기 

	
}