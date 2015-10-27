/*
 * Filename: ProductofArrayExceptSelf.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 15 Jul 2015 09:38:39 PM EDT
 */

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new int[0];
		}

		int n = nums.length;
		int[] res = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				res[i] = 1;
			} else {
				res[i] = res[i-1] * nums[i-1];
			}
		}

		int prod = 1;
		for (int i = n-1; i >= 0; i--) {
			if (i != n-1) {
				prod *= nums[i+1];
			}

			res[i] *= prod;
		}
		return res;
	}
}
