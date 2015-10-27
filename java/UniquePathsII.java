/*
 * Filename: UniquePaths.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 07:03:53 PM EDT
 */

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] A = new int[n];

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				flag = true;
			}

			if (flag) {
				A[i] = 0;
			} else {
				A[i] = 1;
			}
		}

		flag = false;
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					A[j] = 0;
					continue;
				}

				if (j == 0) {
					if (obstacleGrid[i][j] == 1) {
						flag = true;
					}

					if (flag) {
						A[j] = 0;
					}
				} else {
					if (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1) {
						A[j] = 0;
					} else if (obstacleGrid[i-1][j] == 1) {
						A[j] = A[j-1];
					} else if (obstacleGrid[i][j-1] == 1) {
						continue;
					} else {
						A[j] += A[j-1];
					}
				}
			}
		}

		return A[n-1];
	}
}
