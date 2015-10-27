/*
 * Filename: MinimumPathSum.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 08:56:33 PM EDT
 */

public class Solution {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[] A = new int[n];

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				A[i] = grid[0][i];
			} else {
				A[i] = A[i-1] + grid[0][i];
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					A[j] += grid[i][j];
				} else {
					A[j] = Math.min(A[j-1], A[j]) + grid[i][j];
				}
			}
		}

		return A[n-1];
	}
}
