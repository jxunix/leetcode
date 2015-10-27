/*
 * Filename: SetMatrixZeroes.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 20 May 2015 01:57:34 PM EDT
 */

public class Solution {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		boolean row0 = false;
		boolean col0 = false;

		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				col0 = true;
				break;
			}
		}

		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				row0 = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		if (col0) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}

		if (row0) {
			for (int j = 0; j < m; j++) {
				matrix[0][j] = 0;
			}
		}
	}
}
