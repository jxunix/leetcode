/*
 * Filename: SearchinRotatedSortedArray.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 01:24:12 PM EDT
 */

public class Solution {
	public boolean search(int[] nums, int target) {
		int n = nums.length;

		if (n == 0) {
			return false;
		}

		if (n == 1) {
			if (nums[0] == target) {
				return true;
			} else {
				return false;
			}
		}

		int i = 1;
		while (i < n && nums[i-1] <= nums[i]) {
			i++;
		}

		int head = 0;
		int tail = n - 1;
		int mid;
		int val;
		
		while (head <= tail) {
			mid = (head + tail) / 2;
			val = nums[(mid + i) % n];
			if (val == target) {
				return true;
			} else if (val < target) {
				head = mid + 1;
			} else {
				tail = mid - 1;
			}
		}

		return false;
	}
}
