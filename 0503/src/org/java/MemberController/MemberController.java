package org.java.MemberController;

import java.util.Scanner;

import org.java.MemberCommend.MemberCommend;
import org.java.MemberCommend.MemberDeletoDo;
import org.java.MemberCommend.MemberInsertDo;
import org.java.MemberCommend.MemberLoginDo;
import org.java.MemberCommend.MemberSelectDo;
import org.java.MemberCommend.MemberUpdateDo;

public class MemberController {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		MemberCommend action = null;
		
		System.out.println("Äõ¸®¹® ÀÔ·Â : ");
		String query = scan.next();
		
		if (query.equals("insert")) {
			action = new MemberInsertDo();
			action.excuteQueryCommend();
		}else if(query.equals("delete")) {
			action = new MemberDeletoDo();
			action.excuteQueryCommend();
		}else if(query.equals("select")) {
			action = new MemberSelectDo();
			action.excuteQueryCommend();
		}else if(query.equals("login")) {
			action = new MemberLoginDo();
			action.excuteQueryCommend();
		}else if(query.equals("update")) {
			action = new MemberUpdateDo();
			action.excuteQueryCommend();
		}
	}	
}