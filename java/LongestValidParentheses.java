/*
 * Filename: LongestValidParentheses.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 12:32:43 PM EDT
 */

public class Solution {
	public int longestValidParentheses(String s) {
		if (s.length() == 0) {
			return 0;
		}

		int maxLen = 0;
		int[] d = new int[s.length()];
		d[s.length() - 1] = 0;

		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				d[i] = 0;
			} else {
				int j = i + 1 + d[i+1];
				if (j < s.length() && s.charAt(j) == ')') {
					d[i] = d[i+1] + 2;
					if (j + 1 < s.length()) {
						d[i] += d[j + 1];
					}
				}
			}
			maxLen = Math.max(maxLen, d[i]);
		}

		return maxLen;
	}
}
