package org.java.javabcollection;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		System.out.println("Vectpr");
		Vector<Integer> v1 = new Vector<Integer>();
		/*
		v1.add(new Integer(10)); //박싱
		v1.add(20); // Integer a = 10(자동박싱)
		v1.add(new Integer(30));
		v1.add(new Integer(40));
		v1.add(new Integer(50));
	
		for(int i=0;i<v1.size(); i++) {
			System.out.println(v1.get(i));
		}
		
		System.out.println();
		//foreach문
		for(Integer i : v1) {
			System.out.println(i+""); 
		}
		System.out.println();
		//Iterator
		Iterator<Integer> iterator = v1.iterator();
		while(iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.println(i + " ");
		}
		*/
		//scanner이용해서 1~5까지 정수입력해 Vector에 저장하고 콘솔에 출력하는 프로그래밍
		//scanner, vector, iterator, sysout 이용 while문사용 ~50
		
		Vector<Integer> v3 = new Vector<Integer>();
		
		int idx =0;	//횟수
		
		while(true) {
			System.out.println("숫자입력 : "); //1,2,3,4,5
			Scanner in = new Scanner(System.in);
			int num = in.nextInt();
			
			v3.add(new Integer(num));
			
		 	//if(num == 5) break;
		 	if(idx==5) break;
		}
		Iterator<Integer> iterator2 = v3.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next() + " ");
		}
	}	
}