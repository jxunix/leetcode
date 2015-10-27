/*
 * Filename: WildcardMatching.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 11 May 2015 02:14:52 PM EDT
 */

public class Solution {
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
				i++;
				j++;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
		}
		
		while (j < p.length() && p.charAt(j) == '*') {
		    j++;
		}

		return j == p.length();
	}
}
