package org.web.MemberDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.DBConnect.DBConnect;
import org.web.MemberDTO.MemberDTO;


public class MemberDAO {


    //�̱��� "�ѹ� ��ü�� ����"
    private static final MemberDAO dao=new MemberDAO();//�ѹ��� �ʱ�ȭ
    
    public MemberDAO() {}// �����ڸ� private
    
    public static MemberDAO getInstance() {
        //�ܺο��� MemberDao�� ������ �� static�ż���� ����.
        return MemberDAO.dao;
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


    //ȸ����ȸ
    public ArrayList<MemberDTO> members(){
        ArrayList<MemberDTO> lists = new ArrayList<MemberDTO>();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String query = "";
        
        try {
            conn =DBConnect.getConnection(); //
            query = "select userId, userPw, userName, userEmail from joinTest;";            
            pstm = conn.prepareStatement(query);
            
            rs = pstm.executeQuery(); // ��ȸ, DB �����͸� get
            
            while(rs.next()) {                 
                lists.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
    
	public boolean idCheck(String userId) {
		//id�� ������ ..  false(ȸ�����Խ�, �Ұ�)
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
				bool = true; // ���̵� �����ϸ�
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
    
	public boolean Login(String userId, String userPw) {
		
		boolean bool = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query ="";
		
		
		idCheck(userId); // id�� ������ �α��� ����
		
		
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
				bool = true; // ���̵� �����ϸ�

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return bool;
	}

}