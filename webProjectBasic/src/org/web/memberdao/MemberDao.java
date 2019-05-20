package org.web.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.web.dbconnect.DBConnect;

public class MemberDao {

	//�̱��� "�ѹ� ��ü�� ����"
	private static final MemberDao dao=new MemberDao();//�ѹ��� �ʱ�ȭ
	
	private MemberDao() {}// �����ڸ� private
	
	public static MemberDao getInstance() {
		//�ܺο��� MemberDao�� ������ �� static�ż���� ����.
		return MemberDao.dao;
	}
	
	public int insert(String userId,String userPw,String userName,String userEmail) {
		
		int rs=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		String query="";
		
		conn=DBConnect.getConnection();
		query="insert into joinTest(userId,userPw,userName,userEmail)"
				+ " values(?,?,?,?);";
		try {
			pstm=conn.prepareStatement(query);
			
			pstm.setString(1, userId);
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setString(4, userEmail);
			
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
	
}
