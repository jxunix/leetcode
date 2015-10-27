/*
 * Filename: PowerofTwo.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 04:48:03 PM EDT
 */

public class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}

		while ((n & 1) == 0) {
			n >>= 1;
		}

		return n == 1;
	}
}
