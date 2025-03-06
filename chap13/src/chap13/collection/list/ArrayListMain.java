package chap13.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		List<Integer> aList1 = new ArrayList<>();
		
		// #1 add(E)
		aList1.add(3);
		aList1.add(4);
		aList1.add(5);
		aList1.add(6);
		System.out.println(aList1.toString());
		
		// #2 add(index, E)
		aList1.add(1, 7);
		System.out.println(aList1.toString());
		
		// #3 addAll(Collection<? extends E> c)
		List<Integer> aList2 = new ArrayList<>();
		aList2.add(1);
		aList2.add(2);
		aList2.add(3);
		aList2.add(4);
		aList2.addAll(aList1);
		System.out.println(aList2.toString());
		
		// #4 addAll(int index, Collection<? extends E> c)
		List<Integer> aList3 = new ArrayList<>();
		aList3.add(1);
		aList3.add(2);
		aList3.addAll(1, aList3);
		System.out.println(aList3.toString());
		
		// #5 set(int Index, Element E)
		aList3.set(1,5);
		System.out.println(aList3.toString());
		
		// #6 remove
		aList3.remove(1);
		System.out.println(aList3.toString());
		
		// #7 remove(Object)
		aList3.remove(new Integer(2));
		System.out.println(aList3.toString());
		
		// #8 clear()
		aList3.clear();
		System.out.println(aList3.toString());
	}

}