package org.java.exceptionEx;

public class ExceptionEx2 {
	public static void main(String[] args) {
		int[] arrInt = new int[5];
		
		
		try {
		for(int i=0; i<6; i++) {
			arrInt[i] = i;
			}
		}
		//���ܹ߻��� �Ǹ� try �� ���� �ڵ�� ������ �ȵȴ�.
		catch(ArrayIndexOutOfBoundsException e){
		for(int i=0; i<6; i++) {
			System.out.println("arrInt[" + i + "]" + arrInt[i]);
			}
		}finally {
		System.out.println("���α׷� ��������");
		}
	}
}
