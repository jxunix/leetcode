/*
 * Filename: LargestRectangleinHistogram.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 22 May 2015 04:49:09 PM EDT
 */

public class Solution {
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);

		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] *
						(stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}

		return maxArea;
	}
}
