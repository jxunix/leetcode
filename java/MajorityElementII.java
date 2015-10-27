/*
 * Filename: MajorityElementII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 04:58:33 PM EDT
 */

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();

		int val = 0;
		int val2 = 0;

		int cnt = 0;
		int cnt2 = 0;

		for (int n : nums) {
			if (n == val) {
				cnt++;
			} else if (n == val2){
				cnt2++;
			} else if (cnt == 0) {
				val = n;
				cnt = 1;
			} else if (cnt2 == 0) {
				val2 = n;
				cnt2 = 1;
			} else {
				cnt--;
				cnt2--;
			}
		}

		cnt = 0;
		cnt2 = 0;

		for (int n : nums) {
			if (n == val) {
				cnt++;
			} else if (n == val2) {
				cnt2++;
			}
		}

		if (cnt * 3 > nums.length) {
			res.add(val);
		}

		if (cnt2 * 3 > nums.length) {
			res.add(val2);
		}

		return res;
	}
}
