package chap13.collection.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetMain {

	public static void main(String[] args) {
		Set<String> lSet1 = new LinkedHashSet<>();
		
		// add(E)
		lSet1.add("가");
		lSet1.add("나");
		lSet1.add("라");
		lSet1.add("다");
		System.out.println(lSet1.toString());
		
		// addAll(Collection<? extends E> c)
		Set<String> lSet2 = new LinkedHashSet<>();
		lSet2.add("A");
		lSet2.add("B");
		lSet2.addAll(lSet1);
		System.out.println(lSet2.toString());
		
		// 삭제 remove(Object)
		lSet2.remove("B");
		System.out.println(lSet2.toString());
		
		// clear
		lSet2.clear();
		System.out.println(lSet2.toString());
		System.out.println(lSet2.size());
		
		// isEmpty
		System.out.println(lSet2.isEmpty());
		
		Set<String> lSet3 = new LinkedHashSet<>();
		lSet3.add("가");
		lSet3.add("가");
		lSet3.add("나");
		lSet3.add("다");
		
		// contains(Object)
		System.out.println(lSet3.contains("나"));
		
		// iterator
		Iterator<String> itr = lSet3.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
		
		// 배열 -> toArray()
		System.out.println(Arrays.toString(lSet3.toArray()));
		
		// toArray(T[] t)
		String[] arrStr1 = lSet3.toArray(new String[0]);
		System.out.println(Arrays.toString(arrStr1));
		
		String[] arrStr2 = lSet3.toArray(new String[5]);
		System.out.println(Arrays.toString(arrStr2));
	}

}
