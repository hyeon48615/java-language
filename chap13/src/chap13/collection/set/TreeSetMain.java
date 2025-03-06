package chap13.collection.set;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain {

	public static void main(String[] args) {
		TreeSet<Integer> tSet1 = new TreeSet<>();
		for(int i=50; i>0; i-=2) {
			tSet1.add(i);
		}
		System.out.println(tSet1.toString());
		
		// #1 first() / last()
		System.out.println(tSet1.first());			// 2
		System.out.println(tSet1.last());			// 50
		
		// #2 lower(E) / higher(E) - 입력값 미포함
		System.out.println(tSet1.lower(24));		// 22
		System.out.println(tSet1.higher(24));		// 26
		
		// #3 floor(E) / ceiling(E) - 입력값 포함
		System.out.println(tSet1.floor(25));		// 24
		System.out.println(tSet1.floor(26));		// 26
		
		System.out.println(tSet1.ceiling(25));		// 26
		System.out.println(tSet1.ceiling(26));		// 26
		
		// # pollFirst() / pollLast()
		System.out.println("tSet1 size: " + tSet1.size()); 				// 25
		System.out.println(tSet1.pollFirst());
		System.out.println("tSet1 pollFirst size: " + tSet1.size());	// 24
		System.out.println(tSet1.pollLast());	
		System.out.println("tSet1 pollLast size: " + tSet1.size());		// 23
		
		tSet1.clear();
		for(int i=50; i>0; i-=2) {
			tSet1.add(i);
		}
		System.out.println(tSet1.toString());
		
		// #9 headSet(E)
		SortedSet<Integer> sSet1 = tSet1.headSet(20);	// default inclusive -> false
		System.out.println(sSet1.toString());	// 2 ~ 18
		
		sSet1 = tSet1.headSet(20, true);
		System.out.println(sSet1.toString());	// 2 ~ 20
		
		// #10 tailSet(E)
		sSet1 = tSet1.tailSet(20);	// default inclusive -> true
		System.out.println(sSet1.toString());	// 20 ~ 50
				
		sSet1 = tSet1.tailSet(20, false);
		System.out.println(sSet1.toString());	// 22 ~ 50
		
		// #11 subSet(from, to)
		sSet1 = tSet1.subSet(20, 40);
		System.out.println(sSet1.toString());		// 20 ~ 38
				
		sSet1 = tSet1.subSet(20, true, 40, true);
		System.out.println(sSet1.toString());		// 20 ~ 40
		
		// # 12 descendingSet()
		NavigableSet<Integer> dSet1 = tSet1.descendingSet();
		System.out.println(dSet1.toString());		// 50 -> 2
	}

}
