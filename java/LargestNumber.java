/*
 * Filename: LargestNumber.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 14 Jul 2015 02:53:33 PM EDT
 */

public class Solution {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}

		Integer[] nums2 = new Integer[nums.length];

		for (int i = 0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}

		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer m, Integer n) {
				String mstr = Integer.toString(m);
				String nstr = Integer.toString(n);

				String mn = mstr.concat(nstr);
				String nm = nstr.concat(mstr);

				return nm.compareTo(mn);
			}
		};

		Arrays.sort(nums2, comparator);
		String res = "";

		for (Integer n : nums2) {
			res = res.concat(Integer.toString(n));
		}

		if (res.replace("0", "").equals("")) {
			return "0";
		}

		return res;
	}
}
