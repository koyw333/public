package org.java.exceptionEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3 {
	public static void main(String[] args) {
		System.out.println("입력 오류");
		//콘솔에 정수를 입력하여 콘솔에 출력
		//InputMismatchException(입력타임과 Scanner의 메서드와 차이)
		System.out.println("정수 입력 : ");
		Scanner in = new Scanner(System.in);
		try {
		int num = in.nextInt();
		System.out.println(num);
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
		System.out.println("예외상관없이 실행");
		} System.out.println("프로그램 종료");
	}
}
