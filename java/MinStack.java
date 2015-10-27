/*
 * Filename: MinStack.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 11:04:34 AM CST
 */

class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minStack.empty() || minStack.peek() >= x) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (stack.empty()) {
			return;
		}
		
		int pop = stack.pop();
		if (!minStack.empty() && pop == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		if (stack.empty()) {
			return 0;
		} else {
			return stack.peek();
		}
	}

	public int getMin() {
		if (minStack.empty()) {
			return stack.peek();
		} else {
			return minStack.peek();
		}
	}
}
