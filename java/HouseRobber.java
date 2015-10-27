/*
 * Filename: HouseRobber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 11:31:24 AM CST
 */

public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}
		
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		if (nums.length == 3) {
			return Math.max(nums[0] + nums[2], nums[1]);
		}

		int max = 0;
		int pMax = nums[2] + nums[0];
		int ppMax = nums[1];
		int pppMax = nums[0];

		for (int i = 3; i < nums.length; i++) {
			max = Math.max(pMax, Math.max(ppMax, pppMax) + nums[i]);
			pppMax = ppMax;
			ppMax = pMax;
			pMax = max;
		}

		return max;
	}
}
