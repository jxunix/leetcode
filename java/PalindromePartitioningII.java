/*
 * Filename: PalindromePartitioning.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 01 Jul 2015 02:50:04 PM EDT
 */

public class Solution {
	public int minCut(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();
		int[] cuts = new int[n+1];
		boolean[][] isPal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			cuts[i] = n - i - 1;
		}

		for (int i = n-1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j-i < 2 || isPal[i+1][j-1])) {
					isPal[i][j] = true;
					cuts[i] = Math.min(cuts[i], cuts[j+1] + 1);
				}
			}
		}

		Aux.print(cuts);

		return cuts[0];
	}
}
