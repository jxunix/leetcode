/*
 * Filename: UniquePaths.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 07:03:53 PM EDT
 */

public class Solution {
	public int uniquePaths(int m, int n) {
		if (m == 1 || n == 1) {
			return 1;
		}

		int[] A = new int[n];
		for (int i = 1; i <= n; i++){
			A[i-1] = i;
		}

		for (int i = 2; i < m; i++) {
			for (int j = 1; j < n; j++) {
				A[j] += A[j-1];
			}
		}

		return A[n-1];  
	}
}
