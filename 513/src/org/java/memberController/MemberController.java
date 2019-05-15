package org.java.memberController;

import java.util.Scanner;

import org.java.memberCommend.IdCheck;
import org.java.memberCommend.MemberDeleteDo;
import org.java.memberCommend.MemberInsertDo;
import org.java.memberCommend.MemberSelectDo;
import org.java.memberCommend.MemberUpdateDo;
import org.java.memberCommend.QueryCommend;
import org.java.memberCommend.loginDo;

public class MemberController {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("쿼리문 입력 : ");
		
		String query = in.next();
		//다형성
		QueryCommend action = null;
	
		if(query.equals("insert")) {
			action= new MemberInsertDo();
			action.excuteQueryCommend();
		}else if(query.equals("delete")) {
			action= new MemberDeleteDo();
			action.excuteQueryCommend();
		}else if(query.equals("select")) {
			action= new MemberSelectDo();
			action.excuteQueryCommend();
		}else if(query.equals("update")) {
			action= new MemberUpdateDo();
			action.excuteQueryCommend();
		}else if(query.equals("exit")){
			System.out.println("종료");
		}else if(query.equals("idChecked")){
			atcion = new IdCheck();
			action.excuteQueryCommend();
		}else if(query.equals("login")){
			action= new loginDo();
			action.excuteQueryCommend();
		}else {
			System.out.println("쿼리문 입력오류");	
		}
	}
}