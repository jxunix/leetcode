/*
 * Filename: UniqueBinarySearchTrees.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 29 May 2015 09:44:12 AM EDT
 */

public class Solution {
	public int numTrees(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		int[] nums = new int[n+1];
		nums[0] = 1;
		nums[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				nums[i] += nums[j] * nums[i-j-1];
			}
		}

		return nums[n];
	}
}
