/*
 * Filename: ImplementstrStr.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 05:35:36 PM EDT
 */

public class Solution {
	public int strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();

		for (int i = 0; i <= len1 - len2; i++) {
			if (haystack.substring(i, i+len2).equals(needle)) {
				return i;
			}
		}

		return -1;
	}
}
