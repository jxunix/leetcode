/*
 * Filename: DivideTwoIntegers.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 13 Mar 2015 05:42:15 PM EDT
 */

public class Solution {
	public int divide(int dividend, int divisor) {
		if (dividend == 0) {
			return 0;
		}

		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}

		long dend = Math.abs((long) dividend);
		long dsor = Math.abs((long) divisor);
		boolean negSign = (dividend < 0) ^ (divisor < 0);
		int ret = 0;

		while (dend >= dsor) {
			long dr = dsor;
			int cnt = 1;
			for (; dr <= dend; cnt <<= 1, dr <<= 1) {
				dend -= dr;
				ret += cnt;
			}
		}

		return negSign ? -ret : ret;
	}
}
