package chap13.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		List<Integer> vector1 = new Vector();
		
		// #1 add(E)
		vector1.add(3);
		vector1.add(4);
		vector1.add(5);
		System.out.println(vector1.toString());
		
		// #2 add(index, E)
		vector1.add(1, 6);
		System.out.println(vector1.toString());
		
		// #3 remove(index)
		vector1.remove(0);
		System.out.println(vector1.toString());
		
		// #4 clear()
		vector1.clear();
		System.out.println(vector1.toString());
		
		// 리스트 -> 배열
		vector1.add(3);
		vector1.add(4);
		vector1.add(5);
		Object[] arrObj = vector1.toArray();
		System.out.println(Arrays.toString(arrObj));
		
		// toArray -> generic
		// Integer[] integer = vector1.toArray(new Integer[0]);
		// System.out.println(Arrays.toString(integer));
		
		Integer[] integer = vector1.toArray(new Integer[5]);
		System.out.println(Arrays.toString(integer));
	}

}
