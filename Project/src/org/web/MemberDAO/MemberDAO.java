package org.web.MemberDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.DBConnect.DBConnect;
import org.web.MemberDTO.MemberDTO;


public class MemberDAO {


    //�̱��� "�ѹ� ��ü�� ����"
    private static final MemberDAO dao=new MemberDAO();//�ѹ��� �ʱ�ȭ
    private static Connection conn = null;
    
    public MemberDAO() {}// �����ڸ� private
    
    public static MemberDAO getInstance() {
        //�ܺο��� MemberDao�� ������ �� static�ż���� ����.
        return MemberDAO.dao;
    }
    
    public int insert(String userId,String userPw,String userName,String userEmail) {
    	
        
        int rs=0;
        
        PreparedStatement pstm=null;
        String query="";
        
        conn=DBConnect.getConnection();
        System.out.println("Connection ����"); 
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
	public ArrayList<MemberDTO> Member_List() {
		
		ArrayList<MemberDTO> lists = new ArrayList<MemberDTO>();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery(); // ��ȸ, DB������ get
			
			while (rs.next()) {
				
				lists.add(new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				
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
			} finally {}
			
		}
		
		return lists;
		
	}
    //�α��� üũ
	public boolean idCheck(String userId) {
		//id�� ������ ..  false(ȸ�����Խ�, �Ұ�)
		boolean bool = false;
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query ="select*from member where userId=?;";
		System.out.println("query pass");
		
		
		try {
			conn = DriverManager.getConnection(query, userId, query);
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
    //�α���
	public int Login(String userId, String userPw, HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String query="select*from joinTest where userId=? and userPw=?;";
		System.out.println("query ok");
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userId);	
			pstm.setString(2, userPw);
			pstm.setString(3, userName);
			pstm.setString(4, userEmail);
			System.out.println(userPw);
   			rs = pstm.executeQuery();//
			System.out.println("rs ok");
			if(rs.next()){
	            if (rs.getString(1).contentEquals(userPw)) {
	                return 1;

			}else{
				return 0 ;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}return 3;
	}
}