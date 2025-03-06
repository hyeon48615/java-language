package chap13.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapMain {

	public static void main(String[] args) {
		Map<Integer, String> hMap1 = new HashMap<>();
		
		// #1 put(k, v)
		hMap1.put(2, "나다마");
		hMap1.put(1, "가나다");
		hMap1.put(4, "가나다");
		hMap1.put(3, "다라마");
		hMap1.put(4, "ABC"); // 값을 덮어씌움
		
		System.out.println(hMap1.toString());
		
		// #2 putAll
		Map<Integer, String> hMap2 = new HashMap<>();
		hMap2.putAll(hMap1);
		System.out.println(hMap2.toString());	// {1=가나다, 2=나다마, 3=다라마, 4=ABC}
		
		// #3 replace(k, v)
		hMap2.replace(1,"가가가");
		hMap2.replace(4, "나나나");
		System.out.println(hMap2.toString());
		
		// #4 replace(k, old, new)
		hMap2.replace(1,  "가가가", "xxxx");
		hMap2.replace(1,  "노노노", "xxxx");
		System.out.println(hMap2.toString());
		
		// #5 get(k)
		System.out.println(hMap2.get(1));
		System.out.println(hMap2.size());
		
		// #6 containsKey(k)
		System.out.println(hMap2.containsKey(4));			// true
		
		// #7 containsValue(v)
		System.out.println(hMap2.containsValue("나다마"));	// true
		
		// #8 keySet()
		Set<Integer> hKeySet = hMap2.keySet();
		System.out.println(hKeySet.toString());	// [1, 2, 3, 4]
		
		// List 중복 제거 : List -> Set -> List
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("B");
		aList.add("A");
		aList.add("C");
		
		Set<String> aSet = new HashSet<>(aList);
		System.out.println(aSet.toString());
		
		List<String> bList = new ArrayList<>(aSet);
		System.out.println(bList.toString());
		
		System.out.println(List.copyOf(Set.copyOf(aList)));
		
		// #9 entrySet()
		Set<Map.Entry<Integer, String>> entrySet = hMap2.entrySet();
		System.out.println(entrySet.toString());	// [1=xxxx, 2=나다마, 3=다라마, 4=나나나]
		
		// #10 size
		System.out.println(hMap2.size());
		
		// #11 remove(key)
		hMap2.remove(1);
		hMap2.remove(4);
		System.out.println(hMap2.toString());
		
		// #12 remove(k, v)
		hMap2.remove(1, "xxxx");
		hMap2.remove(4, "노노노");
		System.out.println(hMap2.toString());	// {}
		
		// #13 clear()
		hMap2.clear();
		System.out.println(hMap2.toString());
		System.out.println(hMap2.size());
		System.out.println(hMap2.isEmpty());
		
		Map<Integer, String> lm1 = new LinkedHashMap<>();
		lm1.put(2, "가");
		lm1.put(4, "다");
		lm1.put(3, "나");
		lm1.put(5, "가");
		lm1.put(2, "라");
		
		System.out.println(lm1.toString());
	}

}
