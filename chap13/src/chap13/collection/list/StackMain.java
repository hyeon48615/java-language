package chap13.collection.list;

import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		// #1 push
		stack.push(1);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		System.out.println(stack.toString());
		
		// #2 peek
		System.out.println(stack.peek());	// 7
		System.out.println(stack.size());	// 4
		
		// #3 search
		System.out.println(stack.search(3)); // 2
		
		// #4 pop
		System.out.println(stack.pop());	// 7
		System.out.println(stack.size());	// 3
	}

}
