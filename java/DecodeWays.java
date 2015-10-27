/* * Filename: DecodeWays.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 27 May 2015 04:34:18 PM EDT
 */

public class Solution {
	public int numDecodings(String s) {
		if (s.length() == 0) {
			return 0;
		}

		int i = 0;
		int res = 1;
		int cnt = 0;

		while (i < s.length()) {
			if (s.charAt(i) <= '0' || s.charAt(i) > '9') {
				return 0;
			}

			while (i < s.length() && s.charAt(i) >= '3' && s.charAt(i) <= '9') {
				i++;
			}

			if (i == s.length()) {
				break;
			}

			if (s.charAt(i) <= '0' || s.charAt(i) > '9') {
				return 0;
			}

			cnt = 0;
			while (i < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2')) {
				i++;
				cnt++;
			}

			if (s.charAt(i-1) == '1') {
				if (i == s.length()) {
					res *= fib(cnt + 1);
				} else if (s.charAt(i) == '0') {
					res *= fib(cnt);
				} else if (s.charAt(i) > '0' && s.charAt(i) <= '9') {
					res *= fib(cnt + 2);
				} else {
					return 0;
				}
			} else if (s.charAt(i-1) == '2') {
				if (i == s.length()) {
					res *= fib(cnt + 1);
				} else if (s.charAt(i) == '0') {
					res *= fib(cnt);
				} else if (s.charAt(i) > '6' && s.charAt(i) <= '9') {
					res *= fib(cnt + 1);
				} else if (s.charAt(i) > '0' && s.charAt(i) <= '6') {
					res *= fib(cnt + 2);
				} else {
					return 0;
				}
			}

			i++;
		}

		return res;
	}

	private int fib(int n) {
		int prev = 0;
		int val = 1;
		int tmp;

		if (n == 0) {
			return prev;
		} else if (n == 1) {
			return val;
		}

		for (int i = 0; i < n; i++) {
			tmp = prev;
			prev = val;
			val += tmp;
		}

		return prev;
	}
}
