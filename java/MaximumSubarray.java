/*
 * Filename: MaximumSubarray.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 15 May 2015 07:34:04 PM EDT
 */

public class Solution {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int max = nums[0];
		int mmax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			mmax = Math.max(nums[0], mmax + nums[i]);
			max = Math.max(mmax, max);
		}

		return max;
	}
}
