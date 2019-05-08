package org.java.Ramda;

interface InterfaceEx1{
	void abMethod();
	void abMethod2();
}



public class RamdaEx1 {
	public static void main(String[] args) {
		//인터페이스 -> 익명 클래스 구현
		InterfaceEx1 in1 = new InterfaceEx1() {
			
			@Override
			public void abMethod() {
					System.out.println("오버라이드 메서드");
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
