package org.web.DBConnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {


    public static Connection getConnection() {
        
        Connection conn=null;
        
        String url="jdbc:mysql://3.17.133.136/team1DB?useSSL=false&serverTimezone=UTC" + "&allowPublicKeyRetrieval=true";
        String user="team1";
        String password="Daewoo1team!";
    
        
        try {
            Class.forName("com.mysql.jdbc.Driver");//����̹� �ε�
            System.out.println("����̹�OK");


            conn=DriverManager.getConnection(url, user, password);//DB����
            System.out.println("DB���� OK");            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
        
        return conn;
    }
}