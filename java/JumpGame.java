/*
 * Filename: JumpGame.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 15 May 2015 08:39:00 PM EDT
 */

public class Solution {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return true;
		}

		int i = nums.length - 1;
		int cnt = 0;
		int mark = nums.length;
		boolean rres = false;
		boolean res = true;
		boolean no0 = true;

		while (i >= 0 && nums[i] == 0) {
			cnt++;
			mark = i;
			rres = false;
			i--;
		}

		if (mark != nums.length) {
			while (i >= 0 && nums[i] != 0) {
				if (nums[i] >= mark - i + cnt - 1) {
					rres |= true;
				}
				i--;
			}
			res &= rres;
			cnt = 0;
		} else {
			while (i >= 0 && nums[i] != 0) {
				i--;
			}
		}

		while (i >= 0) {
			while (i >= 0 && nums[i] == 0) {
				cnt++;
				mark = i;
				rres = false;
				i--;
			}

			while (i >= 0 && nums[i] != 0) {
				if (nums[i] > mark - i + cnt - 1) {
					rres |= true;
				}
				i--;
			}

			res &= rres;
			cnt = 0;
		}

		return res;
	}
}
