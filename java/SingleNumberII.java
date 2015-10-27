/*
 * Filename: SingleNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 08:25:05 PM EDT
 */

public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;

		for (int i = 0; i < 32; i++) {
			int bit = (1 << i);
			int cnt = 0;

			for (int n: nums) {
				if ((n & bit) != 0) {
					cnt++;
				}
			}

			if (cnt % 3 == 1) {
				res |= bit;
			}
		}

		return res;
	}
}
