/*
 * Filename: SpiralMatrix.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 15 May 2015 08:06:53 PM EDT
 */

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int eend = Math.min(m, n);
		int end = eend / 2;

		for (int i = 0; i < end; i++) {
			for (int j = i; j < n-i-1; j++) {
				res.add(matrix[i][j]);
			}

			for (int j = i; j < m-i-1; j++) {
				res.add(matrix[j][n-i-1]);
			}

			for (int j = n-i-1; j > i; j--) {
				res.add(matrix[m-i-1][j]);
			}

			for (int j = m-i-1; j > i; j--) {
				res.add(matrix[j][i]);
			}
		}

		if (eend % 2 == 1) {
			if (m >= n) {
				for (int i = end; i < m - end; i++) {
					res.add(matrix[i][end]);
				}
			} else {
				for (int i = end; i < n - end; i++) {
					res.add(matrix[end][i]);
				}
			}
		}

		return res;
	}
}
