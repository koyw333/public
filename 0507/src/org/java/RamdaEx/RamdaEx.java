package org.java.RamdaEx;
//1.8 �������̽� �̿��ؼ� �߻� �޼��� ����

interface Parent{
	void son();
}

class MansoMain implements Parent{
	@Override
	public void son() {
		System.out.println("�������̵� ������ü");
	}
}


public class RamdaEx {
	public static void main(String[] args) {
		MansoMain ma1 = new MansoMain();
		ma1.son();// ������ü�� �̿��ؼ� son()���� "������"
		
		//������(�θ�Ÿ���� ��ü�������� �ڽİ�ü ����)
		Parent p1 = new MansoMain();
		p1.son();
			
		P1 p3 = new P1() {
			
			@Override
			public void son2() {
				System.out.println("����(�͸�) Ŭ���� �̿��ؼ� �������̵�");
			}
		};
		p3.son2();
				
		//�͸�Ŭ����(�ϳ��� ����: �������̽� ������ü ����)
		Parent p2 = new Parent() {
			@Override
			public void son(){
				System.out.println("�͸�Ŭ���� �̿��ؼ� �������̵�"); 
			}
		};
		p2.son();
	}
}
