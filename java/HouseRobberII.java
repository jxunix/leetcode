/*
 * Filename: HouseRobberII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 17 Jul 2015 12:48:12 PM EDT
 */

public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		if (n == 1) {
			return nums[0];
		} else if (n == 2) {
			return Math.max(nums[0], nums[1]);
		} else if (n == 3) {
			return Math.max(nums[0], Math.max(nums[1], nums[2]));
		}

		int[] max = new int[n-1];
		max[0] = nums[1];
		max[1] = nums[2];
		max[2] = nums[1] + nums[3];

		int[] mmax = new int[n-1];
		mmax[0] = nums[0];
		mmax[1] = nums[1];
		mmax[2] = nums[0] + nums[2];

		for (int i = 3; i < n-1; i++) {
			max[i] = Math.max(max[i-1], Math.max(max[i-2], max[i-3]) + nums[i+1]);
			mmax[i] = Math.max(mmax[i-1], Math.max(mmax[i-2], mmax[i-3]) + nums[i]);
		}

		return Math.max(max[n-2], mmax[n-2]);
	}
}
