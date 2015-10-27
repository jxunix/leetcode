/*
 * Filename: BitwiseANDofNumbersRange.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 19 Jun 2015 06:12:52 PM CST
 */

public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0) {
			return 0;
		}

		if (m == n) {
			return m;
		}
		
		int res = 0;

		for (int i = 30; i >= 0; i--) {
			int num = (int) Math.pow(2, i);

			if (m >= num && n >= num) {
				m -= num;
				n -= num;
				res += num;
			} else if (n >= num && m < num) {
				break;
			}
		}

		return res;
	}
}
