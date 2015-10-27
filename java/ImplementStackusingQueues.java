/*
 * Filename: ImplementStackusingQueues.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 07:15:02 PM EDT
 */

class MyStack {
	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		while (!queue.isEmpty()) {
			queue2.add(queue.poll());
		}

		queue.add(x);

		while (!queue2.isEmpty()) {
			queue.add(queue2.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
