/*
 * Filename: ReverseInteger.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 04 Mar 2015 06:04:38 PM EST
 */

public class Solution {
	public static int reverse(int x) {
		int digit;
		int rest = x;
		int res = 0;

		while (rest != 0) {
			digit = rest % 10;
			rest = rest / 10;

			if (x > 0) {
				if (res > Integer.MAX_VALUE / 10 ||
						(res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
					return 0;
				} else {
					res = res * 10 + digit;
				}
			} else if (x < 0) {
				if (res < Integer.MIN_VALUE / 10 ||
					(res == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
						return 0;
				} else {
					res = res * 10 + digit;
				}
			}
		}

		return res;
	}
}
