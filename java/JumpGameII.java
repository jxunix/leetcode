/*
 * Filename: JumpGameII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 11 May 2015 03:50:18 PM EDT
 */

public class Solution {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int curr = 0;
		int ret;
		int max;
		int idx = 0;
		int val;

		if (nums.length == 1) {
			ret = 0;
		} else {
			ret = 1;
		}

		while (curr + nums[curr] < nums.length - 1) {
			max = 0;
			for (int j = curr + 1; j <= curr + nums[curr]; j++) {
				val = j + nums[j];
				if (max < val) {
					max = val;
					idx = j;
				}
			}
			curr = idx;
			ret++;
		}

		return ret;
	}
}
