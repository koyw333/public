package org.java.exceptionEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3 {
	public static void main(String[] args) {
		System.out.println("�Է� ����");
		//�ֿܼ� ������ �Է��Ͽ� �ֿܼ� ���
		//InputMismatchException(�Է�Ÿ�Ӱ� Scanner�� �޼���� ����)
		System.out.println("���� �Է� : ");
		Scanner in = new Scanner(System.in);
		try {
		int num = in.nextInt();
		System.out.println(num);
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}finally {
		System.out.println("���ܻ������ ����");
		} System.out.println("���α׷� ����");
	}
}
