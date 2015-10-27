/*
 * Filename: InterleavingString.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 29 May 2015 02:34:09 PM EDT
 */

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.equals("")) {
			return s2.equals(s3);
		}

		if (s2.equals("")) {
			return s1.equals(s3);
		}

		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}

		int m = s1.length();
		int n = s2.length();
		boolean[] test = new boolean[n+1];

		test[0] = true;
		for (int i = 1; i <= n; i++) {
			test[i] = test[i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (j == 0) {
					test[j] = test[j] && (s1.charAt(i-1) == s3.charAt(i-1));
				} else {
					test[j] = (test[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) ||
						(test[j] && s1.charAt(i-1) == s3.charAt(i+j-1));
				}
			}
		}

		return test[n];
	}
}
