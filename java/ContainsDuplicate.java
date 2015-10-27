/*
 * Filename: ContainsDuplicate.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 12:27:50 PM CST
 */

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.contains(nums[i])) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}

		return false;
	}
}
