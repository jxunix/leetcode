/*
 * Filename: KthLargestElementinanArray.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 03:47:51 PM EDT
 */

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
			return 0;
		}

		int[] maxima = new int[k];
		for (int i = 0; i < k; i++) {
			maxima[i] = Integer.MIN_VALUE;
		}

		for (int n : nums) {
			for (int i = 0; i < k; i++) {
				if (n > maxima[i]) {
					int tmp = n;
					n = maxima[i];
					maxima[i] = tmp;
				}
			}
		}

		return maxima[k-1];
	}
}
