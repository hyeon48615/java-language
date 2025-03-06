package chap13.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListvsLinkedMain {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList();
		List<Integer> lList = new LinkedList();
		
		long sTime, eTime=0;
		
		// # ArrayList 추가시간 측정
		sTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			aList.add(i, i);
		}
		eTime = System.nanoTime();
		System.out.println("ArrayList 데이터 추가시간: " + (eTime-sTime) + "ns");
		
		// # LinkedList 추가시간 측정
		sTime = System.nanoTime();
		for(int i=0; i<1000000; i++) {
			lList.add(i, i);
		}
		eTime = System.nanoTime();
		System.out.println("LinkedList 데이터 추가시간: " + (eTime-sTime) + "ns");
		
		// # ArrayList 검색시간 측정
		sTime = System.nanoTime();
		for(int i=0; i<aList.size(); i++) {
			aList.get(i);
		}
		eTime = System.nanoTime();
		System.out.println("ArrayList 데이터 검색시간: " + (eTime-sTime) + "ns");
				
		// # LinkedList 검색시간 측정
		sTime = System.nanoTime();
		for(int i=0; i<lList.size(); i++) {
			lList.get(i);
		}
		eTime = System.nanoTime();
		System.out.println("LinkedList 데이터 검색시간: " + (eTime-sTime) + "ns");
	}

}
