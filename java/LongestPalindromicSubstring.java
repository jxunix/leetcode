/*
 * Filename: LongestPalindromicSubstring.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 04 Mar 2015 04:44:06 PM EST
 */

public class Solution {
	public String longestPalindrome(String s) {
		String substr = "";
		String longestSubstr = "";

		for (int i = 0; i < s.length(); i++) {
			substr = getPalindrome(s, i, i);
			if (substr.length() > longestSubstr.length()) {
				longestSubstr = substr;
			}
			
			substr = getPalindrome(s, i, i+1);
			if (substr.length() > longestSubstr.length()) {
				longestSubstr = substr;
			}
		}

		return longestSubstr;
	}

	private String getPalindrome(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		return s.substring(l + 1, r);
	}
}
