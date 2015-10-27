/*
 * Filename: LengthofLastWord.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 03:18:05 PM EDT
 */

public class Solution {
	public int lengthOfLastWord(String s) {
		if (s == null) {
			return 0;
		}

		int i = s.length() - 1;
		int length = 0;

		while (i >= 0 && s.charAt(i) == ' ') {
			i--;
		}

		while (i >= 0 && s.charAt(i) != ' ') {
			i--;
			length++;
		}

		return length;
	}
}
