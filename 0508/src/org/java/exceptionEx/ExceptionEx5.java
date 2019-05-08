package org.java.exceptionEx;

import java.util.Scanner;

public class ExceptionEx5 {
	public static void main(String[] args) {
		
		int[] arrInt = new int[5];
		
		
		System.out.println("예외처리");
		// 첫번째 숫자(정수) 입력

		Scanner in = new Scanner(System.in);
		
		System.out.println("정수입력 : ");
		int num = in.nextInt();
		
		//예외처리하고 프로그램이 정상 실행 후 종료
		try {
		System.out.println("나눔수입력 : ");
		int div = in.nextInt();
		System.out.println(num/div);
		
		for(int i=0; i<6; i++) {
			arrInt[i] = i;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); //배열의 인덱스 효과
		
		}catch(ArithmeticException e){//0으로 나누었을때 예외처리
			e.printStackTrace();//콘솔에 예외 구문표시
			System.out.println("예외 메시지 :" + e.getMessage());
			System.out.println("예외발생시 실행");
		}catch(Exception e){	//모든 예외 처리
			e.printStackTrace();
		}finally {
			System.out.println("예외 유무와 상관없이 실행(처리)");	
		}
		System.out.println("프로그램 정상종료");
	}
}
