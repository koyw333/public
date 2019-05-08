package org.java.exceptionEx;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int[] arrInt = new int[5];
		
		
		try {
		for(int i=0; i<6; i++) {
			arrInt[i] = i;
			}
		}
		//예외발생이 되면 try 문 다음 코드는 실행이 안된다.
		catch(ArrayIndexOutOfBoundsException e){
		for(int i=0; i<6; i++) {
			System.out.println("arrInt[" + i + "]" + arrInt[i]);
			}
		}finally {
		System.out.println("프로그램 정상종료");
		}
	}
}
