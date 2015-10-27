/*
 * Filename: ValidPalindrome.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 12:52:46 PM CST
 */

public class Solution {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return false;
		}

		if (s.equals("")) {
			return true;
		}

		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(j);

			if (c1 < '0' || (c1 > '9' && c1 < 'a') || c1 > 'z') {
				i++;
				continue;
			}

			if (c2 < '0' || (c2 > '9' && c2 < 'a') || c2 > 'z') {
				j--;
				continue;
			}

			if (c1 == c2) {
				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;
	}
}
