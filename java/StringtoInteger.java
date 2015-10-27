/*
 * Filename: StringtoInteger.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 04 Mar 2015 07:28:00 PM EST
 */

public class Solution {
	public int atoi(String str) {
		int i = 0;

		while (i < str.length() && (int) str.charAt(i) == 32) {
			i++;
		}

		if (i == str.length()) {
			return 0;
		}

		int sign = 1;
		if ((int) str.charAt(i) == '+') {
			i++;
		} else if ((int) str.charAt(i) == '-') {
			i++;
			sign = -1;
		}

		int ret = 0;
		int digit = (int) str.charAt(i) - '0';
		if (digit < 0 || digit > 9) {
			return 0;
		}

		for (; i < str.length(); i++) {
			digit = (int) str.charAt(i) - '0';

			if (digit < 0 || digit > 9) {
				break;
			}

			if (sign == 1) {
				if (ret > Integer.MAX_VALUE / 10 ||
						(ret == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
					return Integer.MAX_VALUE;
				} else {
					ret = ret * 10 + digit;
				}
			} else {
				if (ret * sign < Integer.MIN_VALUE / 10 ||
						(ret * sign == Integer.MIN_VALUE / 10 && digit * sign < Integer.MIN_VALUE % 10)) {
					return Integer.MIN_VALUE;
				} else {
					ret = ret * 10 + digit;
				}
			}
		}

		return ret * sign;
	}
}
