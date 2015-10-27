/*
 * Filename: Pow.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 13 May 2015 01:45:24 PM EDT
 */

public class Solution {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}

		double val = myPow(x, n / 2);

		if (n < 0) {
			x = 1 / x;
			n = -n;
		}

		if (n % 2 == 0) {
			return val * val;
		} else {
			return val * val * x;
		}
	}
}
