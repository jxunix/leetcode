/*
 * Filename: ScrambleString.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 25 Jun 2015 02:29:48 PM EDT
 */

public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.length() == 1) {
			return s1.charAt(0) == s2.charAt(0);
		}

		char[] t1 = s1.toCharArray();
		char[] t2 = s2.toCharArray();
		Arrays.sort(t1);
		Arrays.sort(t2);

		if (!new String(t1).equals(new String(t2))) {
			return false;
		}

		if (s1.equals(s2)) {
			return true;
		}

		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);

			if (isScramble(s11, s21) && isScramble(s12, s22)) {
				return true;
			}

			s21 = s2.substring(0, s2.length() - i);
			s22 = s2.substring(s2.length() - i);

			if (isScramble(s11, s22) && isScramble(s12, s21)) {
				return true;
			}
		}

		return false;
	}
}
