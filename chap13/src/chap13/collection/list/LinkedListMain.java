package chap13.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMain {

	public static void main(String[] args) {
		List<Integer> ll = new LinkedList<>();
		
		// #1 add(E)
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		System.out.println(ll.toString());
		
		// #2 add(index, E)
		ll.add(1, 7);
		System.out.println(ll.toString());
	}

}
