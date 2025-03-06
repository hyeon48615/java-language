package chap13.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class setMain {

	public static void main(String[] args) {
		Set<String> s = new HashSet();
		s.add("가");
		s.add("가");
		s.add("나");
		s.add("나");
		s.add("다");
		s.add("라");
		s.add("마");
		for(Object o : s) {
			System.out.println(o);
		}
		System.out.println(Arrays.toString(s.toArray()));
		
		// 삭제 remove(Object)
		s.remove("다");
		System.out.println(s.toString());
		
		// 요소 초기화, clear()
		s.clear();
		System.out.println(s.toString());	// []
		System.out.println((s == null)); 	// false
		System.out.println(s.size());		// 0
		
		Set<String> s2 = new HashSet();
		System.out.println(s2.isEmpty()); 	// true
		System.out.println(s2.size());		// 0
		
		s2.add("A");
		s2.add("B");
		s2.add("EFG");
		System.out.println(s2.contains("가"));
		
		// iterator
		Iterator<String> iter = s2.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		
		// Set -> 배열
		Object[] arrObj = s2.toArray();
		System.out.println(Arrays.toString(arrObj));
		
		// toArray(T[] t)
		String[] arrStr1 = s2.toArray(new String[0]);	
		System.out.println(Arrays.toString(arrStr1));	// [A, B, EFG]
		
		String[] arrStr2 = s2.toArray(new String[5]);
		System.out.println(Arrays.toString(arrStr2));	// [A, B, EFG, null, null]
		
		String str1 = new String("가나다");
		String str2 = new String("가나다");
		String str3 = "가나다";
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println((str1 == str2));
	}

}