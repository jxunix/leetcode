/*
 * Filename: LongestConsecutiveSequence.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 01 Jul 2015 10:24:47 AM EDT
 */

public class Solution {
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int res = 0;

		for (int n: nums) {
			set.add(n);
		}

		for (int n: nums) {
			int val = n;
			int cnt = 1;

			while (set.contains(++val)) {
				set.remove(val);
				cnt++;
			}

			val = n;
			while (set.contains(--val)) {
				set.remove(val);
				cnt++;
			}

			res = Math.max(res, cnt);
		}

		return res;
	}
}
