package org.web.MemberCommend;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
    private static final long serialVersionUID =  1L;
    
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;
    String query = "";
    
    private String userId, userPw, userName;
    private int userAge;
    
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String dbURL =  "jdbc:mysql://3.17.133.136/team1DB?useSSL=false&serverTimezone=UTC" + "&allowPublicKeyRetrieval=true";
    private String hostId = "team1";
    private String hostPw = "Daewoo1team!";
    
    

    public loginCheck() {
        super();
    }

    protected void doGet(HttpServletRequest  request, HttpServletResponse response) throws  ServletException, IOException {
    	actionDo(request, response);
    }

    protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws  ServletException, IOException {
    	actionDo(request, response);
    }
    
    protected void actionDo(HttpServletRequest  request, HttpServletResponse response) throws  ServletException, IOException {
        userId = request.getParameter("userId");
        userPw = request.getParameter("userPw");
        
        query = "select * from member where id =  '"+ userId +"' and pw = '"+ userPw +"'";
        
        int a = 0;
        try
        {
            Class.forName(driver);
            conn =  DriverManager.getConnection(dbURL, hostId,  hostPw);
            pstm = conn.createStatement();
            a = pstm.executeQuery(query);
            
            while( rs.next() )
            {
                // DB의 컬럼명으로 받아야한다.
                userId = rs.getString("id");
                userPw = rs.getString("pw");
                userName = rs.getString("name");
                userAge = rs.getInt("age");
            
                // 세션 객체
                HttpSession hs =  request.getSession();
                hs.setAttribute("userId",  userId);
                hs.setAttribute("userPw",  userPw);
                hs.setAttribute("userName",  userName);
                hs.setAttribute("userAge",  userAge);
                
                // 로그인 성공 실패에 따른 분기
                // 미완성 로직 , if 조건을  수정해야한다.
                if(a == 1) // 성공 시
                {  response.sendRedirect("LoginOK.jsp");}
                else // 실패 시
                {  response.sendRedirect("LoginNO.jsp");}
            }   
        }
        catch(Exception e) {  e.printStackTrace(); }
        finally
        {
            try
            {
                if( conn != null ) {  conn.close(); }
                if( pstm != null ) {  pstm.close(); }
                if( rs != null ) { rs.close(); }
            }
            catch(Exception e) {  e.printStackTrace(); }
        }
    }
}