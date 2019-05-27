package MemberCommend;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberDAO.MemberDAO;
import MemberDTO.MemberDTO_forAttendance;

public class MemberAttendanceDo implements QueryCommend {

	@Override
	public void excuteQueryCommend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("�⼮�� ��ȸ");
		
		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberDTO_forAttendance> attendanceLists = 
				new ArrayList<MemberDTO_forAttendance>(); // �⼮�� �޾ƿ� ����Ʈ
				
		HttpSession hs = request.getSession();
		String sessionName = (String) hs.getAttribute("sessionName");
		String sessionID = (String) hs.getAttribute("sessionID");
		
		/**************** ���ǰ� �޾ƿͼ� �����ڰ������� �ƴ��� �Ǻ� **************/
		int checkID = 0; // ������ �������� �ƴ��� �Ǻ����� ����
		if (sessionID.equals("root")) 
			checkID = 1; // ������ �����̸� 1
		/*************************************************************/
		
		// idxType : userID�� userName�̳� �Ǻ�
		// idxMonth : ��ȸ �Ⱓ �Ǻ�
		int idxType = 0, idxMonth = 0;
		String selectType = request.getParameter("selectType");
		String selectMonth = request.getParameter("selectMonth");
		String findName = request.getParameter("findName"); // ID�� Name �������ִ� ����
		
		/********************* �Ǻ��ϴ� ��� ***************************/
		if (selectType.equals("userID")) idxType = 1; // ���̵�� �˻��̸� 1
		else if (selectType.equals("userName")) idxType = 2; // �̸����� �˻��̸� 2
		
		if (selectMonth.equals("wholeSelect")) idxMonth = 1; // ��ü��ȸ�� 1
		else if (selectMonth.equals("month2")) idxMonth = 2; // 2��~3���̸� 2
		else if (selectMonth.equals("month3")) idxMonth = 3; // 3��~4���̸� 3
		else if (selectMonth.equals("month4")) idxMonth = 4; // 4��~5���̸� 4
		/************************************************************/
		
		if (checkID == 0) { // �Ϲ� ������ ��
			
			/**************** �л� �̸��� ���ڷ� ���� ( �⼮�θ� �ҷ����� ���� ) ****************/
			String[] stuNameLists = {"������","������","�ǻ��","�����","���¿�","������","������","�ż���",
					"������","������","������","������","������","������","����ȣ","������","��â��","ȫ�α�"};
			
			int checkName = -1;
			
			for (int i = 0; i < stuNameLists.length; i++) {
				if (stuNameLists[i].equals(sessionName)) 
					checkName = i;
			}
			// �迭 �ε����� 0���� ����, �л� ���̺��� ��ȣ�� 1���� �����ϱ� ������ 1�� ���������
			if (checkName > -1)
				checkName++;
			/**********************************************************************/
			
			if (idxType == 1) { // ���̵�� �˻����� ��
				
				if (findName.equals("root")) {
					
					System.out.println("������ ���̵�� �˻�");
					
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('������ ���̵�δ� �˻��� �Ұ����մϴ�')");
					script.println("history.back()");
					script.println("</script>");
					
				} else {
					
					if (sessionID.equals(findName)) {
						
						attendanceLists = 
								dao.Attendance_Lists(idxMonth, checkID, checkName);
						
						request.setAttribute("attendanceLists", attendanceLists);
						
						/********* �⼮�� ��� jsp�� ������ �κ� ***********/
						cal_Attendance_Rate(idxMonth, attendanceLists, request, response);
						/*******************************************/
						
						request.setAttribute("url", "/board.jsp");
						
					} else {
						
						System.out.println("���� ���̵�� �ٸ�");
						
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('���� ���̵�� �ٸ��ϴ�')");
						script.println("history.back()");
						script.println("</script>");
						
					}
					
				}
				
			} else if (idxType == 2) { // �̸����� �˻����� ��
				
				if (sessionName.equals(findName)) {
					
					attendanceLists = 
							dao.Attendance_Lists(idxMonth, checkID, checkName);
					
					request.setAttribute("attendanceLists", attendanceLists);
					
					/********* �⼮�� ��� jsp�� ������ �κ� ***********/
					cal_Attendance_Rate(idxMonth, attendanceLists, request, response);
					/*******************************************/
					
					request.setAttribute("url", "/board.jsp");
					
				} else {
					
					System.out.println("���� �̸��̶� �ٸ�");
					
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('���� �̸��� �ٸ��ϴ�')");
					script.println("history.back()");
					script.println("</script>");
					
				}
				
			} else {
				System.out.println("�⼮����ȸ ����");
			}
			
		} else { // ������ ������ ��
			
			if (idxType == 1) { // ���̵�� �˻����� ��
				
				if (findName.equals("root")) {
					
					System.out.println("������ ���̵�� �˻�");
					
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('������ ���̵�δ� �˻��� �Ұ����մϴ�')");
					script.println("history.back()");
					script.println("</script>");
					
				} else {
					
					int checkName = dao.userID_To_userName(findName);
					
					if (checkName != 100) {
						
						attendanceLists = 
								dao.Attendance_Lists(idxMonth, checkID, checkName);
						
						request.setAttribute("attendanceLists", attendanceLists);
						
						/********* �⼮�� ��� jsp�� ������ �κ� ***********/
						cal_Attendance_Rate(idxMonth, attendanceLists, request, response);
						/*******************************************/
						
						request.setAttribute("url", "/board.jsp");
						
					} else {
						
						System.out.println("�л� ���̵� ����");
						
						PrintWriter script = response.getWriter();
						script.println("<script>");
						script.println("alert('�Է��Ͻ� �л� ���̵�� ��ġ�ϴ� ���̵� �����ϴ�')");
						script.println("history.back()");
						script.println("</script>");
						
					}
					
				}
				
			} else if (idxType == 2) { // �̸����� �˻����� ��

				int checkName = dao.userNameCheck(findName);
				
				if (checkName != 100) {
					
					attendanceLists = 
							dao.Attendance_Lists(idxMonth, checkID, checkName);
					
					request.setAttribute("attendanceLists", attendanceLists);
					
					/********* �⼮�� ��� jsp�� ������ �κ� ***********/
					cal_Attendance_Rate(idxMonth, attendanceLists, request, response);
					/*******************************************/
					
					request.setAttribute("url", "/board.jsp");
					
				} else {
					
					System.out.println("�л� �̸��� ����");
					
					PrintWriter script = response.getWriter();
					script.println("<script>");
					script.println("alert('�Է��Ͻ� �л� �̸��� ��ġ�ϴ� �̸��� �����ϴ�')");
					script.println("history.back()");
					script.println("</script>");
					
				}
				
			}
			
		}
		
	}
	
	public String cal_Attendance_Rate (int idxMonth, ArrayList<MemberDTO_forAttendance> attendanceLists,
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		String rs = "";
		int attendanceCount = 0; // �⼮ �� ���ִ� ����
		int otherCount = 0; // ����, ���� �̷��� ���ִ� ���� (3�� �Ǹ� 0���� �ʱ�ȭ��)
		int otherCount2 = 0; // ����, ���� �̷��� ���ִ� ���� (�������� ����)
		int absenceCount = 0; // �Ἦ �� ���ִ� ����
		int wholeAttendance = 0; // ��ü ������ ��
		
		if (idxMonth == 1) { // ��ü��ȸ
			
			System.out.println("��ü��ȸ ���");
			rs = "��ü��ȸ�� �⼮�� ���� ����� ������� �ʽ��ϴ�";
			request.setAttribute("attendanceRate", rs);
			
		} else if (idxMonth == 2) { // 2�� 19�� ~ 3�� 18��
			
			wholeAttendance = 19;
			
			/****************** �⼮, ����, �Ἦ �� ���� �κ� *****************/
			for (MemberDTO_forAttendance dto : attendanceLists) {
				
				if (dto.getChkNum() == 0) { // �⼮�̸�
					
					attendanceCount ++;
					
				} else if (dto.getChkNum() == 1) { // ����, ���� �̷��Ÿ�
					
					otherCount ++;
					otherCount2 ++;
					if (otherCount == 3) { // ����, ����... ��� 3���̸� �Ἦ 1��
						otherCount = 0;
						absenceCount ++;
					}
					
				} else { // �Ἦ�̸�
				
					absenceCount ++;
					
				}
				
			}
			/********************************************************/
			
			float attendanceRate = (float) attendanceCount / (float) wholeAttendance * 100;
			rs = attendanceRate + "%";
			
			/***************** �⼮�� ����Ѱ� jsp�� ������ �κ� ****************/
			request.setAttribute("attendanceRate", rs);
			request.setAttribute("wholeAttendance", wholeAttendance + "");
			request.setAttribute("attendanceCount", attendanceCount + "");
			request.setAttribute("otherCount2", otherCount2 + "");
			request.setAttribute("absenceCount", absenceCount + "");
			/***********************************************************/
			
			
		} else if (idxMonth == 3) { // 3�� 19�� ~ 4�� 18��
			
			wholeAttendance = 23;
			
			/****************** �⼮, ����, �Ἦ �� ���� �κ� *****************/
			for (MemberDTO_forAttendance dto : attendanceLists) {
				
				if (dto.getChkNum() == 0) { // �⼮�̸�
					
					attendanceCount ++;
					
				} else if (dto.getChkNum() == 1) { // ����, ���� �̷��Ÿ�
					
					otherCount ++;
					otherCount2 ++;
					if (otherCount == 3) { // ����, ����... ��� 3���̸� �Ἦ 1��
						otherCount = 0;
						absenceCount ++;
					}
					
				} else { // �Ἦ�̸�
				
					absenceCount ++;
					
				}
				
			}
			/********************************************************/
			
			float attendanceRate = (float) attendanceCount / (float) wholeAttendance * 100;
			rs = attendanceRate + "%";
			
			/***************** �⼮�� ����Ѱ� jsp�� ������ �κ� ****************/
			request.setAttribute("attendanceRate", rs);
			request.setAttribute("wholeAttendance", wholeAttendance + "");
			request.setAttribute("attendanceCount", attendanceCount + "");
			request.setAttribute("otherCount2", otherCount2 + "");
			request.setAttribute("absenceCount", absenceCount + "");
			/***********************************************************/
			
		} else if (idxMonth == 4) { // 4�� 19�� ~ 5�� 9��
			
			System.out.println("4�� 19�� ~ 5�� 9�� ���");
			rs = "������ �������� ����� ������� �ʽ��ϴ�";
			request.setAttribute("attendanceRate", rs);
			
		}
		
		return rs;
		
	}

}
