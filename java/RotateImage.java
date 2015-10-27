/*
 * Filename: RotateImage.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 12 May 2015 08:56:20 PM EDT
 */

public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}

		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][n-j-1];
				matrix[i][n-j-1] = temp;
			}
		}
	}
}
