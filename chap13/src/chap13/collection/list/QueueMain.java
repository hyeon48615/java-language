package chap13.collection.list;

import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		
		// #1 add
		queue.add(3);
		queue.add(5);
		queue.add(4);
		
		// #2 element
		System.out.println(queue.element());
		System.out.println(queue.size());	// 3
		
		// #3 remove
		System.out.println(queue.remove());
		System.out.println(queue.size()); 	// 2
		
		// #4 peek / poll
		System.out.println(queue.peek());	// 5
		System.out.println(queue.size());	// 2
		
		System.out.println(queue.poll());	// 5
		System.out.println(queue.size());	// 1
		
		queue.clear();
		
		System.out.println(queue.peek());	// null 
		System.out.println(queue.poll());   // null
	}

}
