/*
 * Filename: FindPeakElement.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 16 Jul 2015 10:24:55 PM EDT
 */

public class Solution {
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int stt = 0;
		int end = nums.length - 1;
		int mid;

		while (stt < end) {
			mid = (stt + end) / 2;

			if (nums[mid] > nums[mid + 1]) {
				end = mid;
			} else {
				stt = mid + 1;
			}
		}

		return stt;
	}
}
