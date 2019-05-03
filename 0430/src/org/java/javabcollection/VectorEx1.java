package org.java.javabcollection;

import java.util.Iterator;
import java.util.Vector;


class GenericEx<T>{
	T a;
	T b;
	public T method(T a) {
		return a;
	}
}




public class VectorEx1 {
	public static void main(String[] args) {
		System.out.println("vector");
		//객체생성시 타입을 외부에 결정
		GenericEx<String> g1 = new GenericEx();
		
		//요소 타입을 외부에서 결정(제네릭)
		Vector<String> v1 = new Vector<String>();
		//객체 생성 >> 지정
		
		//백터요소에 추가
		v1.add(new String("Java"));
		v1.add(new String("Spring"));
		v1.add(new String("javascript"));
		v1.add(new String("JSP"));
		v1.add(new String("Servlet"));
		
		System.out.println();
		
		
		
		//3. 벡터를 다른 백터에 추가
		Vector<String> v2 = new Vector<String>();
		v2.add(new String("v2Vector1"));
		v2.add(new String("v2Vector2"));
		v2.add(new String("v2Vector3"));
		System.out.println(v2.size());
		
		v1.addAll(v2);
		System.out.println(v1.size());
		
		//4.백터삭제
		v1.clear();
		System.out.println(v1.size());
		
		//5.객체의 요소에 포함되어 있느냐?
		System.out.println(v1.contains("v2Vector1"));
		
		//6.객체요소를 get
		String s1 = v1.get(0);   // 요소를 get
		System.out.println(s1);
		System.out.println(v1.get(1));
		System.out.println(v1.get(2));
		//size(), get, for문을 이용 백터 v1의 모든 요소를 콘솔에 표시

		for(int i=0; i <v1.size(); i++) {
			System.out.println(v1.get(1));
		}
		for(String str:v1) {
			System.out.println(str);
		}
		
		//Iterator(객체)
		
		Iterator<String> iterator = v1.iterator();
		
		//데이터(객체요소)가 있으면
		while(iterator.hasNext()) {
			String str = iterator.next();//요소를 0번지 순서대로 처리
			System.out.println(str);
		}
		
		
		//7.isEmpty "비었는가?"
		System.out.println(v1.isEmpty());
		
		//8.remove "요소(인덱스)삭제"
		v1.remove(0); //0번지 요소 삭제
		
		Iterator<String> iterator3 = v1.iterator();
		
		while(iterator3.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("===============================");
		
		//9.요소(데이터) 삭제
		v1.remove("STRING"); 
		
		Iterator<String> iterator4 = v1.iterator();
		while(iterator4.hasNext()) {
			String str = iterator4.next(); //0번지
			System.out.println(str);
		}
		
	}
}
