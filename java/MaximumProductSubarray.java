/*
 * Filename: MaximumProductSubarray.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 20 Jun 2015 04:47:26 PM CST
 */

public class Solution {
	public int maxProduct(int nums[]) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int res = nums[0];
		int max = nums[0];
		int min = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int a = nums[i] * max;
			int b = nums[i] * min;
			max = Math.max(Math.max(a, b), nums[i]);
			min = Math.min(Math.min(a, b), nums[i]);
			res = Math.max(res, max);
		}

		return res;
	}
}
