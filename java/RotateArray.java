/*
 * Filename: RotateArray.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 07 Jul 2015 04:44:35 PM EDT
 */

public class Solution {
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return;
		}

		k = k % nums.length;
		if (k == 0) {
			return;
		}

		reverse(nums, 0, nums.length - 1 );
		reverse(nums, 0, k - 1 );
		reverse(nums, k, nums.length - 1 );
	}

	private void reverse(int[] nums, int stt, int end) {
		while (stt < end) {
			int temp = nums[stt];
			nums[stt] = nums[end];
			nums[end] = temp;
			stt++;
			end--;
		}
	}
}
