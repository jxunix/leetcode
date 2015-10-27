/*
 * Filename: MaximalRectangle.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 25 May 2015 03:08:26 PM EDT
 */

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int maxArea = 0;
		int[][] height = new int[m][n+1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0 ? 1 : height[i-1][j] + 1;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			int area = largestRectangleArea(height[i]);
			maxArea = Math.max(maxArea, area);
		}

		return maxArea;
	}

	private int largestRectangleArea(int[] height){
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;

		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}

		return maxArea;
	}
}
