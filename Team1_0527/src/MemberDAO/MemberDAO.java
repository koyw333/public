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
import MemberDTO.MemberDTO_forAttendance;

public class MemberDAO {

	private static final MemberDAO dao = new MemberDAO();
	private static Connection conn = null;
	
	public MemberDAO() {}
	
	public static MemberDAO getInstance() {
		
		return MemberDAO.dao;
	}
	
	/****************************** ȸ������ ****************************************/
	public int insert(String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		// SQL ó��
		// �ؿ� query�� query�� �ۼ��� �� ? �κп� ������ �ڵ����� ����־��ִ� �������ִ³�
		PreparedStatement pstm = null;
		// ���� ������
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "insert into joinTest values(?,?,?,?);";
		
		try {
			// ���� ������
			
			// SQL ó�� ( ?�� value ����ֱ� )
			pstm = conn.prepareStatement(query); // PreparedStatement�� ����
			
			pstm.setString(1, userID.trim());
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
	/***************************************************************************/
	
	/**************************** ȸ�� ��ȸ ********************************/
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
	/***************************************************************************/
	/***************************** ȸ������ - �̸�üũ *************************************/
	public int userNameCheck (String userName) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		/************************** �л� ��� �� *******************************/
		String[] stuNameLists = {"������","������","�ǻ��","�����","���¿�","������","������","�ż���",
					"������","������","������","������","������","������","����ȣ","������","��â��","ȫ�α�"};
		
		int temp = -1;
		
		for (int i = 0; i < stuNameLists.length; i++) {
			if (stuNameLists[i].equals(userName))
				temp = i;
		}
		
		// �迭 �ε����� 0���� ����, �л� ���̺��� ��ȣ�� 1���� �����ϱ� ������ 1�� ���������
		if (temp > -1)
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
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return -2; // �����ͺ��̽� ����
		
	}
	/********************************************************************************************/
	
	/******************************************* �α��� *****************************************/
	public int login (String userID, String userPW, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		String userName, userEmail;
		HttpSession hs = request.getSession();
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // ��ȸ, DB������ get
			
			if (rs.next()) {
				
				if (rs.getString(2).equals(userPW)) {
					
					userName = rs.getString(3);
					userEmail = rs.getString(4);
					
					hs.setAttribute("sessionID", userID);
					hs.setAttribute("sessionPW", userPW);
					hs.setAttribute("sessionName", userName);
					hs.setAttribute("sessionEmail", userEmail);
					
					return 1; // �α��� ����
					
				} else {
					return 2; // ��й�ȣ Ʋ��
				}
				
			}
			
			return 3; // ���̵� ����
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				if (rs != null) rs.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return -2; // �����ͺ��̽� ����
	}
	/****************************************************************************************/
	/*************************** ��й�ȣ ��ġ�ϴ��� Ȯ�� (ȸ������â�� ������) ****************************/
	public int checkPW (String userID, String userPW) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery(); // ��ȸ, DB������ get
			
			if (rs.next()) {
				if (rs.getString(2).equals(userPW)) return 1; // ��й�ȣ ��ġ
				else return 2; // ��й�ȣ ����ġ
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
			} finally {	}
			
		}	
		
		return -2;
		
	}
	/********************************************************************************************/
	/********************************* ȸ������ *****************************/
	public int update (String userID, String userPW, String userName, String userEmail) {
		
		int rs = 0;
		
		PreparedStatement pstm = null;
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "update joinTest set userPW = ?, userName = ?, userEmail = ? where userID = ?;";
		
		try {
			System.out.println("ȸ������ ����");
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, userPW);
			pstm.setString(2, userName);
			pstm.setString(3, userEmail);
			pstm.setString(4, userID);
			
			rs = pstm.executeUpdate();
			System.out.println(rs);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				
				if (conn != null) conn.close();	
				if (pstm != null) pstm.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {	}
			
		}	
		
		return rs;
		
	}
	/*********************************************************************/
	/**************************** ID üũ *******************************/
	public int idCheck (String userID) {
		

		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		
		conn = DBConnect.getConnection();
		query = "select count(*) from joinTest where userID = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				return rs.getInt(1);
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
			} finally {	}
			
		}
		
		return -2; // �����ͺ��̽� ����
		
	}
	/******************************************************************/
	/************************ ȸ�� ���� ****************************/
	public int delete (String userID, String userPW) {
		
		int rs = 0;
		
		PreparedStatement pstm = null;
		String query = "";
	
		conn = DBConnect.getConnection();
		query = "delete from joinTest where userID = ? and userPW = ?";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userID);
			pstm.setString(2, userPW);
			rs = pstm.executeUpdate();
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (conn != null) conn.close();
				if (pstm != null) pstm.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {}
		}
		
		return -2;
		
	}
	/************************************************************/
	/**************************** �⼮�� ��ȸ ****************************/
	public ArrayList<MemberDTO_forAttendance> Attendance_Lists (int idxMonth, int checkID, int checkName) {
		
		System.out.println("�⼮�� ��ȸ DAO");
		
		ArrayList<MemberDTO_forAttendance> attendanceLists =
				new ArrayList<MemberDTO_forAttendance>();
				
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
	
		conn = DBConnect.getConnection();
		
		/****************** �⼮�� ���̺��� �ҷ����� ���ؼ� �̸� ������ֱ� **************/
		String tableName = "student" + checkName + "";
		/******************************************************************/
		
		/***************** �⼮�� ��ȸ ����� ���� Query�� �з� ****************/
		if (checkID == 0) { // �л� ������ ��
			
			if (idxMonth == 1) { // ��ü��ȸ
				query = "select * from " + tableName + ";";
			} else if (idxMonth == 2) { // 2��19�� ~ 3�� 18��
				query = "select * from " + tableName + " where date between '2019-02-19' and '2019-03-18';";
			} else if (idxMonth == 3) { // 3�� 19�� ~ 4�� 18��
				query = "select * from " + tableName + " where date between '2019-03-19' and '2019-04-18';";
			} else if (idxMonth == 4) { // 4�� 19�� ~ 5�� 9��
				query = "select * from " + tableName + " where date between '2019-04-19' and '2019-05-09';";
			}
				
		} else { // ������ ������ ��

			if (idxMonth == 1) { // ��ü��ȸ
				query = "select * from " + tableName + ";";
			} else if (idxMonth == 2) { // 2��19�� ~ 3�� 18��
				query = "select * from " + tableName + " where date between '2019-02-19' and '2019-03-18';";
			} else if (idxMonth == 3) { // 3�� 19�� ~ 4�� 18��
				query = "select * from " + tableName + " where date between '2019-03-19' and '2019-04-18';";
			} else if (idxMonth == 4) { // 4�� 19�� ~ 5�� 9��
				query = "select * from " + tableName + " where date between '2019-04-19' and '2019-05-09';";
			}
		
		}
		/********************************************************/

		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				attendanceLists.add(new MemberDTO_forAttendance(
						rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5)));
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
		
		return attendanceLists;
		
	}
	/*****************************************************************/
	/*************************** ���̵�� �л��̸� ã�� **************************/
	public int userID_To_userName (String findName) {
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		conn = DBConnect.getConnection();
		String query = "select * from joinTest where userID = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			pstm.setString(1, findName);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				System.out.println("���̵� �̸����� �ٲٴ� ��");
				
				String idToName = rs.getString(3); // ID�� Name���� �ٲ㼭 ������ ����
				
				/************************** �л� ��� �� *******************************/
				String[] stuNameLists = {"������","������","�ǻ��","�����","���¿�","������","������","�ż���",
						"������","������","������","������","������","������","����ȣ","������","��â��","ȫ�α�"};
				
				int temp = -1;
				
				for (int i = 0; i < stuNameLists.length; i++) {
					if (stuNameLists[i].equals(idToName))
						temp = i;
				}
				
				// �迭 �ε����� 0���� ����, �л� ���̺��� ��ȣ�� 1���� �����ϱ� ������ 1�� ���������
				if (temp > -1)
					temp++;
				/**********************************************************************/
				
				return temp;
				
			}
			
			return 100; // �̸��� ���� ���
			
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
			} finally {	}
			
		}	
		
		return -2; // �����ͺ��̽� ����
		
	}
	/**********************************************************************/
	
}