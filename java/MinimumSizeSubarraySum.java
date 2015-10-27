/*
 * Filename: MinimumSizeSubarraySum.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 17 Jul 2015 12:24:26 PM EDT
 */

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int sum = 0;
		int res = nums.length;

		while (i < nums.length) {
			sum += nums[i];

			if (sum < s) {
				i++;
			} else {
				while (sum >= s) {
					sum -= nums[j++];
				}

				sum += nums[--j];
				res = Math.min(res, i-j+1);
				i++;
			}
		}

		if (sum < s) {
			return 0;
		}

		return res;
	}
}
