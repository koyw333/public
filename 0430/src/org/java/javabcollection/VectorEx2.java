package org.java.javabcollection;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class VectorEx2 {
	public static void main(String[] args) {
		System.out.println("Vectpr");
		Vector<Integer> v1 = new Vector<Integer>();
		/*
		v1.add(new Integer(10)); //�ڽ�
		v1.add(20); // Integer a = 10(�ڵ��ڽ�)
		v1.add(new Integer(30));
		v1.add(new Integer(40));
		v1.add(new Integer(50));
	
		for(int i=0;i<v1.size(); i++) {
			System.out.println(v1.get(i));
		}
		
		System.out.println();
		//foreach��
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
		//scanner�̿��ؼ� 1~5���� �����Է��� Vector�� �����ϰ� �ֿܼ� ����ϴ� ���α׷���
		//scanner, vector, iterator, sysout �̿� while����� ~50
		
		Vector<Integer> v3 = new Vector<Integer>();
		
		int idx =0;	//Ƚ��
		
		while(true) {
			System.out.println("�����Է� : "); //1,2,3,4,5
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