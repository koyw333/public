package org.java.Ramda;

interface InterEx{
	void excuteQuery();
}

class B implements InterEx{
	@Override
	public void excuteQuery() {
		System.out.println("������ü �������̵�");
	}
}


public class RamdaEx {
	public static void main(String[] args) {
		
		//������ü
		InterEx i1 = new B();
		i1.excuteQuery();
		//1.�͸�Ŭ������ �������̵�(excuteQuery)
		//�������̽� Ÿ�� ���� = new �������̽�(����Ŭ����){//�������̵� �޼���;};
		InterEx i2 = new InterEx() {
			
			@Override
			public void excuteQuery() {
				System.out.println("�͸�Ŭ���� �������̽�����");
			}
		};
		i2.excuteQuery();
		
		//2. ���ٽ����� ����(excuteQuery) " �߻�ż���1��", "�Լ��� �������̽�"
		//void excuteQueyr() �ż���
		InterEx i3 =()->{
			System.out.println("���ٽ����� �߻�޼��� ����");
		};
		i3.excuteQuery();
		
		//3.�޼���ȭ >> @FunctionalInterface
		in i=a->{
			System.out.println("�Լ��� �������̽� ���� : " +  a);
		};
		i.son(100);
	}
	@FunctionalInterface
	interface in{
		void son(int a);
	}
}
