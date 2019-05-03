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
		//��ü������ Ÿ���� �ܺο� ����
		GenericEx<String> g1 = new GenericEx();
		
		//��� Ÿ���� �ܺο��� ����(���׸�)
		Vector<String> v1 = new Vector<String>();
		//��ü ���� >> ����
		
		//���Ϳ�ҿ� �߰�
		v1.add(new String("Java"));
		v1.add(new String("Spring"));
		v1.add(new String("javascript"));
		v1.add(new String("JSP"));
		v1.add(new String("Servlet"));
		
		System.out.println();
		
		
		
		//3. ���͸� �ٸ� ���Ϳ� �߰�
		Vector<String> v2 = new Vector<String>();
		v2.add(new String("v2Vector1"));
		v2.add(new String("v2Vector2"));
		v2.add(new String("v2Vector3"));
		System.out.println(v2.size());
		
		v1.addAll(v2);
		System.out.println(v1.size());
		
		//4.���ͻ���
		v1.clear();
		System.out.println(v1.size());
		
		//5.��ü�� ��ҿ� ���ԵǾ� �ִ���?
		System.out.println(v1.contains("v2Vector1"));
		
		//6.��ü��Ҹ� get
		String s1 = v1.get(0);   // ��Ҹ� get
		System.out.println(s1);
		System.out.println(v1.get(1));
		System.out.println(v1.get(2));
		//size(), get, for���� �̿� ���� v1�� ��� ��Ҹ� �ֿܼ� ǥ��

		for(int i=0; i <v1.size(); i++) {
			System.out.println(v1.get(1));
		}
		for(String str:v1) {
			System.out.println(str);
		}
		
		//Iterator(��ü)
		
		Iterator<String> iterator = v1.iterator();
		
		//������(��ü���)�� ������
		while(iterator.hasNext()) {
			String str = iterator.next();//��Ҹ� 0���� ������� ó��
			System.out.println(str);
		}
		
		
		//7.isEmpty "����°�?"
		System.out.println(v1.isEmpty());
		
		//8.remove "���(�ε���)����"
		v1.remove(0); //0���� ��� ����
		
		Iterator<String> iterator3 = v1.iterator();
		
		while(iterator3.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("===============================");
		
		//9.���(������) ����
		v1.remove("STRING"); 
		
		Iterator<String> iterator4 = v1.iterator();
		while(iterator4.hasNext()) {
			String str = iterator4.next(); //0����
			System.out.println(str);
		}
		
	}
}
