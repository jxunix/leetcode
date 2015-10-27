/*
 * Filename: AddBinary.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 19 May 2015 02:00:37 PM EDT
 */

public class Solution {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}

		if (b == null || b.length() == 0) {
			return a;
		}

		if (a.length() < b.length()) {
			String tmp = a;
			a = b;
			b = tmp;
		}

		int digit;
		int carry = 0;
		String res = "";

		for (int i = a.length() - 1; i >= a.length() - b.length(); i--) {
			digit = carry + a.charAt(i) - '0' + b.charAt(i - a.length() + b.length()) - '0';
			carry = digit / 2;
			digit %= 2;
			res = digit + res;
		}

		for (int i = a.length() - b.length() - 1; i >= 0; i--) {
			digit = carry + a.charAt(i) - '0';
			carry = digit / 2;
			digit %= 2;
			res = digit + res;
		}

		if (carry != 0) {
			res = carry + res;
		}

		return res;
	}
}
