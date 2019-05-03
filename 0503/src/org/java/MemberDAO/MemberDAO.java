package org.java.MemberDAO;
import java.util.ArrayList;
import org.java.MemberDTO.MemberDTO;

public class MemberDAO {

		
	public MemberDAO() {
		System.out.println("DAO");
	}
		
	public int insert(MemberDTO dto) {
		int result = 0;
		
		return result;
	}
	
	public ArrayList<MemberDTO> select(){
		ArrayList<MemberDTO>lists = new ArrayList<MemberDTO>();
		//DB data get
		lists.add(new MemberDTO("m1", "11", "s1", 11));
		lists.add(new MemberDTO("m2", "21", "s2", 21));
		lists.add(new MemberDTO("m3", "31", "s3", 31));
		lists.add(new MemberDTO("m4", "41", "s4", 41));
		lists.add(new MemberDTO("m5", "51", "s5", 51));
		
		return lists;
	}
	
	
	
	public int delete(String userId, String userPw) {
		int result = 0;
		//userId, userPw�� �� ��ġ�ϸ� Ż�𼺰�(1), �ƴϸ� ����
		
		ArrayList<MemberDTO>lists = new ArrayList<MemberDTO>();
		//DB data get
		lists.add(new MemberDTO("m1", "11", "s1", 11));
		lists.add(new MemberDTO("m2", "21", "s2", 21));
		lists.add(new MemberDTO("m3", "31", "s3", 31));
		lists.add(new MemberDTO("m4", "41", "s4", 41));
		lists.add(new MemberDTO("m5", "51", "s5", 51));
		
		for(int i=0; i<lists.size(); i++) {
			//lists.get(i);
			//userId, userPw�� lists�� getUserId, getUserPw ��
			if(lists.get(i).getUserId().equals(userId)&&
					lists.get(i).getUserId().equals(userPw)) {
				result = 1;
				break;
			}else {
				result = 0;
			}
		}
		return result;
	}
	
	public int MemberLogin(String userId, String userPw) {
		int result = 0;
		//userId, userPw�� �� ��ġ�ϸ� Ż�𼺰�(1), �ƴϸ� ����
		ArrayList<MemberDTO>lists = new ArrayList<MemberDTO>();
		//DB data get
		lists.add(new MemberDTO("m1", "11", "s1", 11));
		lists.add(new MemberDTO("m2", "21", "s2", 21));
		lists.add(new MemberDTO("m3", "31", "s3", 31));
		lists.add(new MemberDTO("m4", "41", "s4", 41));
		lists.add(new MemberDTO("m5", "51", "s5", 51));
		
		//userId. userPw�� lists�� getUserId, getUserPw ��
		for(int i=0; i<lists.size(); i++) {
			//lists.get(i);
			//userId, userPw�� lists�� getUserId, getUserPw ��
			if(lists.get(i).getUserId().equals(userId)&&
					lists.get(i).getUserId().equals(userPw)) {
				result = 1;		//�α��μ���
				return result;
			}else {
				result = 0;
			}
		}
		return result;
	}
	
	public MemberDTO member(String userId) {
		MemberDTO list = null;

		ArrayList<MemberDTO>lists = new ArrayList<MemberDTO>();
		//DB data get
		lists.add(new MemberDTO("m1", "11", "s1", 11));
		lists.add(new MemberDTO("m2", "21", "s2", 21));
		lists.add(new MemberDTO("m3", "31", "s3", 31));
		lists.add(new MemberDTO("m4", "41", "s4", 41));
		lists.add(new MemberDTO("m5", "51", "s5", 51));
		
		//userId�� ��ġ
		for(int i=0; i<lists.size(); i++) {
			if(lists.get(i).getUserId().equals(userId)){
				list = new MemberDTO(lists.get(i).getUserId(), lists.get(i).getUserPw(),
						lists.get(i).getUserName(), lists.get(i).getUserAge());
				return list;
			}else {
				System.out.println("��ġ�ϴ� �ɹ��� �����ϴ�.");
			}
		}
		return list;
	}	
}