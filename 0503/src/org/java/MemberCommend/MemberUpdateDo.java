package org.java.MemberCommend;
import java.util.Scanner;
import org.java.MemberDAO.MemberDAO;
import org.java.MemberDTO.MemberDTO;

public class MemberUpdateDo implements MemberCommend{
	@Override
	public void excuteQueryCommend() {
		System.out.println("ȸ������ : ");
		//�α��� ���� DB���̵�� ����(Session �̿�)
		// �����͸� get �� �Ŀ� ����
		
		MemberDAO dao = new MemberDAO();
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("���̵� �Է�");
		String userId = in.next();
		
		MemberDTO list = dao.member(userId);
		
		if(list!=null) {
			System.out.println("ȸ������ �۾� ����");
		}else {
			System.out.println("ȸ������ �۾� ����"); 
		}
		
		
	}
}
