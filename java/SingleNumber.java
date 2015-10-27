/*
 * Filename: SingleNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 02 Jul 2015 08:25:05 PM EDT
 */

public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;

		for (int n: nums) {
			res ^= n;
		}

		return res;
	}
}
