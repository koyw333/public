package org.java.Ramda;

interface InterfaceEx1{
	void abMethod();
	void abMethod2();
}



public class RamdaEx1 {
	public static void main(String[] args) {
		//�������̽� -> �͸� Ŭ���� ����
		InterfaceEx1 in1 = new InterfaceEx1() {
			
			@Override
			public void abMethod() {
					System.out.println("�������̵� �޼���");
			}

			@Override
			public void abMethod2() {
	
			}
		};
		in1.abMethod(); //
		
		
		InterfaceEx1 in2()->{

		}
	}
}
