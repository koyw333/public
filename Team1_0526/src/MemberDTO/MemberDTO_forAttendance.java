package MemberDTO;

public class MemberDTO_forAttendance {
	
	private String date; // ��¥
	private String chk; // �⼮���� (�ѱ�)
	private String startTime; // ��ٽð�
	private String endTime; // ��ٽð�
	private int chkNum; // �⼮���� (����)
	
	public MemberDTO_forAttendance() {
		super();
	}

	public MemberDTO_forAttendance(String date, String chk, String startTime, String endTime, int chkNum) {
		super();
		this.date = date;
		this.chk = chk;
		this.startTime = startTime;
		this.endTime = endTime;
		this.chkNum = chkNum;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getChk() {
		return chk;
	}

	public void setChk(String chk) {
		this.chk = chk;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getChkNum() {
		return chkNum;
	}

	public void setChkNum(int chkNum) {
		this.chkNum = chkNum;
	}
	
}
