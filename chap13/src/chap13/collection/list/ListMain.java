package chap13.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain {

	public static void main(String[] args) {
		// #1. 배열
		String[] array1 = new String[] {"가", "나", "다", "라"};
		array1[2] = null;
		array1[3] = null;
		
		System.out.println(array1.length);
		System.out.println(Arrays.toString(array1));
		
		// #2. 리스트
		List<String> aList = new ArrayList<>();
		aList.add("가");
		aList.add("나");
		aList.add("다");
		aList.add("라");
		aList.add("마");
		aList.add("바");
		
		System.out.println(aList.size());
		System.out.println(aList);
		
		aList.remove("다");
		aList.remove("라");
		
		System.out.println(aList.size());
		System.out.println(aList);
		System.out.println(aList.get(0));
	}

}
