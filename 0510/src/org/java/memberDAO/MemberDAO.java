package org.java.memberDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.DirContext;
import javax.naming.spi.ResolveResult;

import org.java.memberDTO.memberDTO;

public class MemberDAO {

	
	String dbURL = "jdbc:mysql://localhost:3306/javaStudy?useSSL=false&serverTimezone=UTC";
	String hostId = "root";
	String hostPw = "12345";

	
	public MemberDAO() {
		//1. ����̹��ε�
		
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
	
		//Connect ����
		Connection conn = null;
		//SQL�� ó��
		PreparedStatement pstm = null;
		// ���� ������
		String query = "";
		
		
		try {
			//DB����
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "insert into member(userId, userPw, userName, userAge)"
				+ "values (?,?,?,?);" ;
			pstm = conn.prepareStatement(query); // PreparedStaement�� ����
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setInt(4, userAge);
			
			//����
			rs = pstm.executeUpdate(); // ��ȸ, ����, Ż�� ... ���ϰ��� 1�̸� ����
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null) conn.close();//��������
				if(pstm!=null) conn.close();//��������
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
			//DB����
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "delete from member where userId = ?;";
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			
			rs=pstm.executeUpdate(); //1�̸� ����	
			
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
			//DB����
			conn = DriverManager.getConnection(dbURL, hostId, hostPw);
			query = "update member set userPw=?,userName=?,userAge=? where userId=?";;
			pstm = conn.prepareStatement(query); //PreapredStatsu�� ����
			
			//sql ó��
			pstm.setString(1, userPw);
			pstm.setString(2, userName);
			pstm.setInt(3, userAge);
			pstm.setString(4, userId);
			
			rs=pstm.executeUpdate(); //1�̸� ����
			
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
			
			rs = pstm.executeQuery();//DB ������ get
			while(rs.next()) {//DB�����Ͱ� ������ ��� get
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
	
}