/*
 * Filename: ContainsDuplicateII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 04 Jun 2015 12:22:26 PM CST
 */

public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length <= 1) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(i - map.get(nums[i])) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}

		return false;
	}
}
