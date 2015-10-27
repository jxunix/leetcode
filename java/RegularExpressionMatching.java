/*
 * Filename: RegularExpressionMatching.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Thu 05 Mar 2015 10:56:42 AM EST
 */

public class Solution {
	public boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	private boolean isMatch(String s, int i, String p, int j) {
		int ls = s.length();
		int lp = p.length();

		if (j == lp) {
			return i == ls;
		}

		if ((j < lp - 1 && p.charAt(j+1) != '*') || j == lp - 1) {
			return (i < ls && s.charAt(i) == p.charAt(j) || p.charAt(j) == '.' ) &&
				isMatch(s, i+1, p, j+1);
		}

		while ((i < ls && s.charAt(i) == p.charAt(j)) || (p.charAt(j)) == '.' &&
				i < ls) {
			if (isMatch(s, i, p, j+2)) {
				return true;
			}
			i++;
		}
		return isMatch(s, i, p, j+2);
	}
}
