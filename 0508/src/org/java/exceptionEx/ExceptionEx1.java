package org.java.exceptionEx;

import java.util.Scanner;

public class ExceptionEx1 {
	public static void main(String[] args) {
		System.out.println("����ó��");
		// ù��° ����(����) �Է�

		Scanner in = new Scanner(System.in);
		
		System.out.println("�����Է� : ");
		int num = in.nextInt();
		
		//����ó���ϰ� ���α׷��� ���� ���� �� ����
		try {
		System.out.println("�������Է� : ");
		int div = in.nextInt();
		System.out.println(num/div);
		
		
		
		}catch(ArithmeticException e){//0���� ���������� ����ó��
			e.printStackTrace();//�ֿܼ� ���� ����ǥ��
			System.out.println("���� �޽��� :" + e.getMessage());
			System.out.println("���ܹ߻��� ����");
		}finally {
			System.out.println("���� ������ ������� ����(ó��)");	
		}
		System.out.println("���α׷� ��������");
	}
}
