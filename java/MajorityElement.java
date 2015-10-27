/*
 * Filename: MajorityElement.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 18 Jun 2015 11:05:15 AM CST
 */

public class Solution {
	public int majorityElement(int[] nums) {
		int idx = 0;
		int cnt = 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[idx]) {
				cnt++;
			} else {
				cnt--;
			} 

			if (cnt == 0) {
				idx = i;
				cnt = 1;
			}
		}

		return nums[idx];
	}
}
