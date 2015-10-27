/*
 * Filename: FactorialTrailingZeroes.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 17 Jun 2015 04:28:21 PM CST
 */

public class Solution {
	public int trailingZeroes(int n) {
		if (n < 0) {
			return -1;
		}

		int count = 0;
		int i = n / 5;

		while (i > 0) {
			count += i;
			i = i / 5;
		}

		return count;
	}
}
