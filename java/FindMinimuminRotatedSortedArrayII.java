/*
 * Filename: FindMinimuminRotatedSortedArrayII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 03:16:36 PM EDT
 */

public class Solution {
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length - 1 && nums[i] > nums[i+1]) {
				return nums[i+1];
			}
		}

		return nums[0];
	}
}
