package org.java.exceptionEx;

import java.util.Scanner;

public class ExceptionEx5 {
	public static void main(String[] args) {
		
		int[] arrInt = new int[5];
		
		
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
		
		for(int i=0; i<6; i++) {
			arrInt[i] = i;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); //�迭�� �ε��� ȿ��
		
		}catch(ArithmeticException e){//0���� ���������� ����ó��
			e.printStackTrace();//�ֿܼ� ���� ����ǥ��
			System.out.println("���� �޽��� :" + e.getMessage());
			System.out.println("���ܹ߻��� ����");
		}catch(Exception e){	//��� ���� ó��
			e.printStackTrace();
		}finally {
			System.out.println("���� ������ ������� ����(ó��)");	
		}
		System.out.println("���α׷� ��������");
	}
}
