package org.java.Ramda;


interface Sub1{
	public void son(int a);
}
interface Sub22{
	public void son2();
}
interface Sub33{
	public void son3(int a, int b);
}

public class RamdaEx2 {
	public static void main(String[] args) {
		//�������̽� Sub33 �� ���ٽ����� ������ ������..
		//�� ���� �Է��ؼ� �μ��� ���� �ֿܼ� ���
			
		Sub33 sub33 =(int a, int b)->{
			System.out.println(a+b); 
		};
		
		sub33.son3(100, 200);
		
		
		
		
		
		Sub1 sub1;
		//�͸� Ŭ����
		sub1 = new Sub1() {
			@Override
			public void son(int a) {
				System.out.println("�������̵� : " + a); 
			}
		};
		sub1.son(100);
		//���ٽ�, �Ű�����Ÿ���� ��������, �Ű����� �ϳ��ΰ�� ��ȣ��������
		// int a (a) a
		
		sub1=(a)->{			//�Ű����� Ÿ���� ��������
			int num = a+10;
			System.out.println("���ٽ� : " + num);
		};
		sub1.son(100);
		
		//���๮(ó����, ������)�� �ϳ��ϰ�� {} ��������
		sub1=a->System.out.println("���ٽ� : " + a);
		
		
		Sub22 sub2;
		
		sub2 = new Sub22() {

			@Override
			public void son2() {
				System.out.println("���ٽ����� ����");
				
			}
		};
		sub2.son2();
		
		//���ٽ�
		sub2=()->{
			
		};
		
		
		
		
	}
}
