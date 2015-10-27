/*
 * Filename: SummaryRanges.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 06 Jul 2015 03:59:56 PM EDT
 */

public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		List<Integer> range = new ArrayList<Integer>();
		range.add(nums[0]);
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i-1] + 1) {
				range.add(nums[i-1]);
				range.add(nums[i]);
			}
		}

		range.add(nums[nums.length - 1]);

		int stt = 0;
		int end = 0;

		for (int i = 0; i < range.size(); i++) {
			if (i % 2 == 0) {
				stt = range.get(i);
			} else {
				end = range.get(i);
				
				if (stt != end) {
					res.add(stt + "->" + end);
				} else {
					res.add(Integer.toString(stt));
				}
			}
		}

		return res;
	}
}
