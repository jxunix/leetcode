/*
 * Filename: BasicCalculator.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 07:24:37 PM EDT
 */

public class Solution {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		int res = 0;
		int i = 0;

		while (i < s.length()) {
			char c = s.charAt(i);

			if (c == ' ') {
				i++;
			} else if (c == '+') {
				sign = 1;
				i++;
			} else if (c == '-') {
				sign = -1;
				i++;
			} else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
				i++;
			} else if (c == ')') {
				int ssign = stack.pop();
				int rres = stack.pop();
				res = rres + ssign * res;
				i++;
			} else if (c >= '0' && c <= '9') {
				int num = c - '0';
				int j = i+1;

				while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
					num = num * 10 + (s.charAt(j) - '0');
					j++;
				}

				res += sign * num;
				i = j;
			}
		}

		return res;
	}
}
