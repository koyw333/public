package org.java.memberDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.DirContext;
import javax.naming.spi.DirStateFactory.Result;
import javax.naming.spi.ResolveResult;

import org.java.connect.DBConnect;
import org.java.memberDTO.memberDTO;

public class MemberDAO {

	
	String dbURL = "jdbc:mysql://localhost:3306/javaStudy?useSSL=false&serverTimezone=UTC";
	String hostId = "root";
	String hostPw = "12345";

	
	public MemberDAO() {
		//1. 드라이버로드
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("DirverOK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DriverNO");
		}
	}
	
	public int insert(String userId, String userPw,
			String userName, int userAge) {
		int rs = 0;
	
		//Connect 생성
		Connection conn = null;
		//SQL문 처리
		PreparedStatement pstm = null;
		// 실패 쿼리문
		String query = "";
		
		
		try {
			//DB연동
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "insert into member(userId, userPw, userName, userAge)"
				+ "values (?,?,?,?);" ;
			pstm = conn.prepareStatement(query); // PreparedStaement에 저장
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setInt(4, userAge);
			
			//실행
			rs = pstm.executeUpdate(); // 조회, 수정, 탈퇴 ... 리턴값이 1이면 성공
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null) conn.close();//연결해제
				if(pstm!=null) conn.close();//연결해제
			}catch(Exception e) {
				e.printStackTrace();
				}
			}
	
		return rs;
	}

	
	
	public int delete(String userId) {
			
		int rs = 0;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		
		try {
			//DB연결
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "delete from member where userId = ?;";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeUpdate(); //1이면 성공	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(conn!=null) pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
		
	}
	
	public int update(String userPw, String userName, int userAge, String userId) {

		int rs = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		
		try {
			//DB연결
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "update member set userPw=?,userName=?,userAge=? where userId=?";;
			pstm = conn.prepareStatement(query); //PreapredStatsu에 저장
			
			//sql 처리
			pstm.setString(1, userPw);
			pstm.setString(2, userName);
			pstm.setInt(3, userAge);
			pstm.setString(4, userId);
			
			rs=pstm.executeUpdate(); //1이면 성공
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(conn!=null) pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
		
	}

	public ArrayList<memberDTO> select(){
		ArrayList<memberDTO> lists = new ArrayList<memberDTO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "select userId,userPw,userName,userAge from member;";
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery();//DB 데이터 get
			while(rs.next()) {//DB데이터가 있으면 모두 get
				String userId = rs.getString(1);
				String userPw = rs.getString(2);
				String userName = rs.getString(3);
				int userAge = rs.getInt(4);		
				
				memberDTO dto = new memberDTO(userId, userPw, userName, userAge); 
				
				lists.add(dto);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			}
		}
		return lists;
	}
	
	
	// id 체크
	
	// select * from member where userId = 'm1' // return 객체
	// select count(*) from member where userId = 'm1'; // return int
	
	public boolean idCheck(String userId) {
		//id가 있으면 ..  false(회원가입시, 불가)
		boolean bool = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query ="";
		
		
		try {
			conn = DriverManager.getConnection(query, userId, query);
			query = "select*from member where userId=?;";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			pstm.executeQuery();//
			
			if(rs.next());
				bool = true; // 아이디가 존재함ㅕㄴ
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) conn.close();
				if(rs!=null) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
			}
		}
		return bool;
		
	}
	
	public boolean login(String userId, String userPw) {
		
		boolean bool = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query ="";
		
		
		idCheck(userId); // id가 없으면 로그인 실패
		
		
		if(idCheck(userId)!=true) {
			return bool;
		}else {
			
		}
		
		
		try {
			conn = DriverManager.getConnection(query, userId, query);
			query="select*from member where userId=? and userPw=?;";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			pstm.executeQuery();//
			
			if(rs.next());
				bool = true; // 아이디가 존재하면

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return bool;
	}
	

	
	public memberDTO member(String userId) {
		memberDTO member = null;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		
		conn=DBConnect.getConnection();
		query = "select userID,userPw,userName,userAge where userId=?;";
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeQuery();
			
			while(rs.next()) {
				member=new memberDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();
				if(rs!=null) rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		return member;
	}
	
}