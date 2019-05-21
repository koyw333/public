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

	//�̱��� "�ѹ� ��ü�� ����"
	private static final MemberDao dao=new MemberDao();//�ѹ��� �ʱ�ȭ
	
	private MemberDao() {}// �����ڸ� private
	
	public static MemberDao getInstance() {
		//�ܺο��� MemberDao�� ������ �� static�ż���� ����.
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
			
			rs=pstm.executeUpdate();//ȸ�� ���� ���� 1
			
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

	//ȸ����ȸ
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
			
			rs = pstm.executeQuery(); // ��ȸ, DB �����͸� get
			
			while(rs.next()) { // DB �����Ͱ������� ������ �� ����Ͷ�
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
