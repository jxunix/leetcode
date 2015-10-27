/*
 * Filename: Searcha2DMatrixII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 04:06:55 PM EDT
 */

public class Solution {
	public int searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int row = m-1;
		int col = 0;

		while (row >= 0 && row < m && col >= 0 && col < n) {
			int val = matrix[row][col];

			if (val == target) {
				return true;
			} else if (val > target) {
				row--;
			} else {
				col++;	
			}
		}

		return false;
	}
}
