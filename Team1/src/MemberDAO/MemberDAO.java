package MemberDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnect.DBConnect;
import MemberDTO.MemberDTO;

public class MemberDAO {

	private static final MemberDAO dao = new MemberDAO();
	private static Connection conn = null;
	
	public MemberDAO() {}
	
	public static MemberDAO getInstance() {
		
		return MemberDAO.dao;
	}
	
	public int insert(String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		// SQL ó��
		// �ؿ� query�� query�� �ۼ��� �� ? �κп� ������ �ڵ����� ����־��ִ� �������ִ³�
		PreparedStatement pstm = null;
		// ���� ������
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "insert into joinTest(userID, userPW, userName, userEmail) " +
				"values(?,?,?,?);";
		
		try {
			// ���� ������
			
			// SQL ó�� ( ?�� value ����ֱ� )
			pstm = conn.prepareStatement(query); // PreparedStatement�� ����
			
			pstm.setString(1, userID);
			pstm.setString(2, userPW);
			pstm.setString(3, userName);
			pstm.setString(4, userEmail);
			
			
			// ����
			rs = pstm.executeUpdate(); // ��ȸ, ����, Ż��.... ���ϰ��� 1�̸� ���� 0�̸� ����
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
				try {
					
					if (conn != null) conn.close();	
					if (pstm != null) pstm.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {	}
				
		}		
	
		return -1;
		
	}
	
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
			// TODO Auto-generated catch block
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
	
	/********************* ȸ������ - �̸�üũ **************************/
	public int userNameCheck (String userName) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		/************************** �л� ��� �� *******************************/
		String[] stuNameLists = {"������","������","�ǻ��","�����","���¿�","������","������","�ż���",
					"������","������","������","������","������","������","����ȣ","������","��â��","ȫ�α�"};
		
		int temp = 0;
		
		for (int i = 0; i < stuNameLists.length; i++) {
			if (stuNameLists[i].equals(userName))
				temp = i;
		}
		
		// �迭 �ε����� 0���� ����, �л� ���̺��� ��ȣ�� 1���� �����ϱ� ������ 1�� ���������
		if (temp > 0)
			temp++;
		/**********************************************************************/
		
		conn = DBConnect.getConnection();
		String query = "select * from students where stuNum = " + temp + ";";
		
		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				System.out.println("�̸�ã�� ����");
				return Integer.parseInt(rs.getString(1));
			}
			
			return 100; // �̸��� ���� ���
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -2; // �����ͺ��̽� ����
		
	}
	/*********************************************************/
	
	
	public int login (String userID, String userPW, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		String userName, userEmail; // Session�� ������� �̸��� �̸���
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // ��ȸ, DB������ get
			
			if (rs.next()) {
				
				if (rs.getString(2).equals(userPW)) {

					userName = rs.getString(3);
					userEmail = rs.getString(4);
					
					HttpSession hs = request.getSession();
					hs.setAttribute("userID", userID);
					hs.setAttribute("userPW", userPW);
					hs.setAttribute("userName", userName);
					hs.setAttribute("userEmail", userEmail);
					
					return 1; // �α��� ����
					
				} else {
					return 2; // ��й�ȣ Ʋ��
				}
				
			}
			
			return 3; // ���̵� ����
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -2; // �����ͺ��̽� ����
	}
	
	
}