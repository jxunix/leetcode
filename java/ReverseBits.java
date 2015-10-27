/*
 * Filename: ReverseBits.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 05 Jun 2015 07:08:56 AM CST
 */

public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int res = 0;

		for (int i = 0; i < 32; i++) {
			res <<= 1;
			res += n & 1;
			n >>= 1;
		}

		return res;
	}
}
