/*
 * Filename: ShortestPalindrome.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 19 Jul 2015 10:14:03 PM EDT
 */

public class Solution {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		int mid = s.length() / 2;
		String res = "";

		for (int i = mid; i >= 0; i--) {
			if (s.length() % 2 == 0) {
				if (i < mid) {
					res = getPalindrome(s, i, i);
					if (res != null) {
						return res;
					}
				}

				if (i > 0) {
					res = getPalindrome(s, i-1, i);
					if (res != null) {
						return res;
					}
				}
			} else {
				res = getPalindrome(s, i, i);
				if (res != null) {
					return res;
				}

				if (i > 0) {
					res = getPalindrome(s, i-1, i);
					if (res != null) {
						return res;
					}
				}
			}
		}

		return res;
	}

	private String getPalindrome(String s, int i, int j) {
		while (i >= 0) {
			if (s.charAt(i) != s.charAt(j)) {
				return null;
			}

			i--;
			j++;
		}

		StringBuilder sb = new StringBuilder(s.substring(j));
		sb.reverse();
		return sb + s;
	}
}
