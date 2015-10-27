/*
 * Filename: SpiralMatrixII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 03:23:02 PM EDT
 */

public class Solution {
	public int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}

		if (n == 0) {
			return new int[0][0];
		}

		if (n == 1) {
			return new int[][]{ { 1 } };
		}

		int[][] res = new int[n][n];
		int val = 1;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n-2*i-1; j++) {
				res[i][j+i] = val++;
			}

			for (int j = 0; j < n-2*i-1; j++) {
				res[j+i][n-1-i] = val++;
			}

			for (int j = 0; j < n-2*i-1; j++) {
				res[n-1-i][n-1-j-i] = val++;
			}

			for (int j = 0; j < n-2*i-1; j++) {
				res[n-1-j-i][i] = val++;
			}
		}

		if (n % 2 == 1) {
			res[n / 2][n / 2] = n * n;
		}

		return res;
	}
}
