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
		//인터페이스 Sub33 을 람다식으로 구현해 보세요..
		//두 수를 입력해서 두수의 합이 콘솔에 출력
			
		Sub33 sub33 =(int a, int b)->{
			System.out.println(a+b); 
		};
		
		sub33.son3(100, 200);
		
		
		
		
		
		Sub1 sub1;
		//익명 클래스
		sub1 = new Sub1() {
			@Override
			public void son(int a) {
				System.out.println("오버라이드 : " + a); 
			}
		};
		sub1.son(100);
		//람다식, 매개변수타입은 생략가능, 매개인자 하나인경우 괄호생략가능
		// int a (a) a
		
		sub1=(a)->{			//매개변수 타입은 생략가능
			int num = a+10;
			System.out.println("람다식 : " + num);
		};
		sub1.son(100);
		
		//실행문(처리문, 구현문)이 하나일경우 {} 생략가능
		sub1=a->System.out.println("람다식 : " + a);
		
		
		Sub22 sub2;
		
		sub2 = new Sub22() {

			@Override
			public void son2() {
				System.out.println("람다식으로 구현");
				
			}
		};
		sub2.son2();
		
		//람다식
		sub2=()->{
			
		};
		
		
		
		
	}
}
