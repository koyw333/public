package org.java.RamdaEx;
//1.8 인터페이스 이용해서 추상 메서드 구현

interface Parent{
	void son();
}

class MansoMain implements Parent{
	@Override
	public void son() {
		System.out.println("오버라이딩 구현객체");
	}
}


public class RamdaEx {
	public static void main(String[] args) {
		MansoMain ma1 = new MansoMain();
		ma1.son();// 구현객체를 이용해서 son()구현 "다형성"
		
		//다형성(부모타입의 객체참조변수 자식객체 참주)
		Parent p1 = new MansoMain();
		p1.son();
			
		P1 p3 = new P1() {
			
			@Override
			public void son2() {
				System.out.println("무명(익명) 클래스 이용해서 오버라이딩");
			}
		};
		p3.son2();
				
		//익명클래스(하나의 역할: 인터페이스 구현객체 역할)
		Parent p2 = new Parent() {
			@Override
			public void son(){
				System.out.println("익명클래스 이용해서 오버라이딩"); 
			}
		};
		p2.son();
	}
}
