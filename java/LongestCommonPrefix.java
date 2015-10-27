/*
 * Filename: LongestCommonPrefix.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 02:59:15 PM EDT
 */

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		return longestCommonPrefix(strs, 0, strs.length);
	}

	private String longestCommonPrefix(String[] strs, int i, int j) {
		if (i+1 == j) {
			return strs[i];
		}

		if (i+2 == j) {
			return commonPrefix(strs[i], strs[i+1]);
		}

		int mid = (i + j) / 2;
		String comm1 = longestCommonPrefix(strs, i, mid);
		String comm2 = longestCommonPrefix(strs, mid, j);

		return commonPrefix(comm1, comm2);
	}

	private String commonPrefix(String s, String t) {
		int i = 0;
		int minLen = Math.min(s.length(), t.length());
		for (; i < minLen; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				break;
			}
		}
		return s.substring(0, i);
	}
}
