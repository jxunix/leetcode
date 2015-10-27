/*
 * Filename: ImplementQueueusingStacks.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 03:41:43 PM EDT
 */

class MyQueue {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		while (!stack.isEmpty()) {
			stack2.push(stack.pop());
		}

		stack.push(x);

		while (!stack2.isEmpty()) {
			stack.push(stack2.pop());
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!stack.isEmpty()) {
			stack.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (!stack.isEmpty()) {
			return stack.peek();
		}

		return 0;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}
