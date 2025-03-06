package chap13.collection.map;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapMain {

	public static void main(String[] args) {
		TreeMap<Integer, String> tmap1 = new TreeMap<>();
		for(int i=20; i>0; i-=2) {
			tmap1.put(i, i+"번 데이터");
		}
		System.out.println(tmap1.toString()); // 2 ~ 20
											  // -> 입력 순서 관계 없이 크기 순으로 출력
		
		// #1 firstKey() / firstEntry()
		System.out.println(tmap1.firstKey());		// 2 
		System.out.println(tmap1.firstEntry());		// 2=2번 데이터
		
		// #2 lastKey() / lastEntry()
		System.out.println(tmap1.lastKey());		// 20
		System.out.println(tmap1.lastEntry());		// 20=20번 데이터
		
		// #3 lowerKey(K)/ higherKey(K)
		System.out.println(tmap1.lowerKey(10));		// 8
		System.out.println(tmap1.higherKey(10));	// 12
		
		// #4 pollFirstEntry() / pollLastEntry()
		System.out.println("tmap1 size: " + tmap1.size()); 				// 10
		System.out.println(tmap1.pollFirstEntry());
		System.out.println("tmap1 pollFirst size: " + tmap1.size());	// 9
		System.out.println(tmap1.pollLastEntry());	
		System.out.println("tmap1 pollLast size: " + tmap1.size());		// 8
		
		// #5 headMap(K)
		SortedMap<Integer, String> smap1 = tmap1.headMap(8);
		System.out.println(smap1.toString());	// {4=4번 데이터, 6=6번 데이터}
		
		smap1 = tmap1.headMap(8, true);
		System.out.println(smap1.toString());	// {4=4번 데이터, 6=6번 데이터, 8=8번 데이터}
		
		// #6 tailMap(K)
		smap1 = tmap1.tailMap(14);				
		System.out.println(smap1.toString()); 	// {14=14번 데이터, 16=16번 데이터, 18=18번 데이터}
		
		smap1 = tmap1.tailMap(14, false);				
		System.out.println(smap1.toString());	// {16=16번 데이터, 18=18번 데이터}
		
		// #7 subMap(fromK, toK)
		smap1 = tmap1.subMap(6, 10);
		System.out.println(smap1.toString());	// {6=6번 데이터, 8=8번 데이터}
		
		smap1 = tmap1.subMap(6, true, 10, true);
		System.out.println(smap1.toString());	// {6=6번 데이터, 8=8번 데이터, 10=10번 데이터}
		
		// #8 descendingKeySet() / descendingMap()
		NavigableSet<Integer> dset = tmap1.descendingKeySet();
		System.out.println(dset.toString());	// [18, 16, 14, 12, 10, 8, 6, 4]
		
		NavigableMap<Integer, String> dmap = tmap1.descendingMap();
		System.out.println(dmap.toString());	// {18=18번 데이터, ..., 6=6번 데이터, 4=4번 데이터}
	}

}
