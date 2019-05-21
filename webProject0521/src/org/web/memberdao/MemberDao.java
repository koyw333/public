package org.web.memberdao;
import org.web.MemeberDto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.MemeberDto.MemberDto;
import org.web.dbconnect.DBConnect;

public class MemberDao {

	//싱글톤 "한번 객체를 생성"
	private static final MemberDao dao=new MemberDao();//한번만 초기화
	
	private MemberDao() {}// 생성자를 private
	
	public static MemberDao getInstance() {
		//외부에서 MemberDao에 접근할 때 static매서드로 접근.
		return MemberDao.dao;
	}
	
	public int insert(String userId,String userPw,String userName,int userAge) {
		
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		conn=DBConnect.getConnection();
		query="insert into member(userId,userPw,userName,userAge)  "
				+ " values(?,?,?,?);";
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setInt(4, userAge);
			
			rs=pstm.executeUpdate();//회원 가입 성공 1
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {				
				if(conn!=null) conn.close();
				if(pstm!=null) pstm.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {}
		}
		
		return rs;
	}

	//회원조회
	public ArrayList<MemberDto> members(){
		ArrayList<MemberDto> lists = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			conn =DBConnect.getConnection(); //
			query = "select userId, userPw, userAge from member;";			
			pstm = conn.prepareStatement(query);
			
			rs = pstm.executeQuery(); // 조회, DB 데이터를 get
			
			while(rs.next()) { // DB 데이터가있으면 무조건 다 대려와라
				 /*String userId = rs.getString(1);
				 String userPw = rs.getString(2);
				 String userName = rs.getString(3);
				 int userAge = rs.getInt(4);
				 
				 MemberDto dto = new MemberDto(userId, userPw, userName, userAge);
				 lists.add(dto);*/
				
				lists.add(new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {}
		}
		
		return lists;
	}
	
	
	
	
	
	
	
}
