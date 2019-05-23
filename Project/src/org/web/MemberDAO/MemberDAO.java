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


    //싱글톤 "한번 객체를 생성"
    private static final MemberDAO dao=new MemberDAO();//한번만 초기화
    private static Connection conn = null;
    
    public MemberDAO() {}// 생성자를 private
    
    public static MemberDAO getInstance() {
        //외부에서 MemberDao에 접근할 때 static매서드로 접근.
        return MemberDAO.dao;
    }
    
    public int insert(String userId,String userPw,String userName,String userEmail) {
    	
        
        int rs=0;
        
        PreparedStatement pstm=null;
        String query="";
        
        conn=DBConnect.getConnection();
        System.out.println("Connection 성공"); 
        query="insert into joinTest(userId,userPw,userName,userEmail)"
                + " values(?,?,?,?);";
        try {
            pstm=conn.prepareStatement(query);
            pstm.setString(1, userId);
            pstm.setString(2, userPw);
            pstm.setString(3, userName);
            pstm.setString(4, userEmail);

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
    //로그인 체크
	public boolean idCheck(String userId) {
		//id가 있으면 ..  false(회원가입시, 불가)
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
				bool = true; // 아이디가 존재하면
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
    //로그인
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