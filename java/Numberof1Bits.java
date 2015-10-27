/*
 * Filename: Numberof1Bits.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 05 Jun 2015 06:54:26 AM CST
 */

public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
	    int res = 0;
	    
		if (n < 0) {
			n -= Integer.MIN_VALUE;
			res++;
		}

		for (int i = 0; i < 32; i++) {
			res += n & 1;
			n >>= 1;
		}

		return res;
	}
}
