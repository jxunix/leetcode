/*
 * Filename: SortColors.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 20 May 2015 05:11:07 PM EDT
 */

public class Solution {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			if (nums[i] != 0 && nums[j] == 0) {
				nums[j] = nums[i];
				nums[i] = 0;
				i++;
				j--;
			} else if (nums[i] != 0) {
				j--;
			} else if (nums[j] == 0) {
				i++;
			} else {
				i++;
				j--;
			}
		}

		j = nums.length - 1;
		while (i < j) {
			if (nums[i] == 2 && nums[j] == 1) {
				nums[i] = 1;
				nums[j] = 2;
				i++;
				j--;
			} else if (nums[i] == 2) {
				j--;
			} else if (nums[j] == 1) {
				i++;
			} else {
				i++;
				j--;
			}
		}
	}
}
