package org.java.Ramda;

interface InterEx{
	void excuteQuery();
}

class B implements InterEx{
	@Override
	public void excuteQuery() {
		System.out.println("구현객체 오버라이드");
	}
}


public class RamdaEx {
	public static void main(String[] args) {
		
		//구현객체
		InterEx i1 = new B();
		i1.excuteQuery();
		//1.익명클래스로 오버라이드(excuteQuery)
		//인터페이스 타입 변수 = new 인터페이스(구현클래스){//오버라이드 메서드;};
		InterEx i2 = new InterEx() {
			
			@Override
			public void excuteQuery() {
				System.out.println("익명클래스 인터페이스구현");
			}
		};
		i2.excuteQuery();
		
		//2. 람다식으로 구현(excuteQuery) " 추상매서드1개", "함수적 인터페이스"
		//void excuteQueyr() 매서드
		InterEx i3 =()->{
			System.out.println("람다식으로 추상메서드 구현");
		};
		i3.excuteQuery();
		
		//3.메서드화 >> @FunctionalInterface
		in i=a->{
			System.out.println("함수적 인터페이스 구현 : " +  a);
		};
		i.son(100);
	}
	@FunctionalInterface
	interface in{
		void son(int a);
	}
}
