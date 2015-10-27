/*
 * Filename: DistinctSubsequences.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 27 Jun 2015 02:49:11 PM EDT
 */

public class Solution {
	public int numDistinct(String s, String t) {
		if (t.length() == 0) {
			return 1;
		}

		if (s.length() == 0) {
			return 0;
		}

		return numDistinctAux(s, t);
	}

	public int numDistinctAux(String s, String t) {
		int m = t.length() + 1;
		int n = s.length() + 1;
		int[][] nums = new int[m][n];

		for (int i = m-1; i >= 0; i--) {
			for (int j = n-1; j >= 0; j--) {
				if (i == m-1) {
					nums[i][j] = 1;
				} else {
					if (j == n-1) {
						nums[i][j] = 0;
					} else {
						if (s.charAt(j) == t.charAt(i)) {
							nums[i][j] = nums[i+1][j+1] + nums[i][j+1];
						} else {
							nums[i][j] = nums[i][j+1];
						}
					}
				}
			}
		}

		return nums[0][0];
	}
}
