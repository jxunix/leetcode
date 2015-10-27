/*
 * Filename: SubsetsII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 27 May 2015 02:08:18 PM EDT
 */

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return res;
		}

		Arrays.sort(nums);
		for (int i = 0; i <= nums.length; i++) {
			List<List<Integer>> tmp = combine(nums, nums.length, i);
			res.addAll(tmp);
		}

		res.add(new ArrayList<Integer>());
		return res;
	}

	private List<List<Integer>> combine(int[] nums, int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (n <= 0 || k <= 0) {
			return res;
		}

		if (k == 1) {
			for (int i = 0; i < n; i++) {
				if (i > 0 && nums[i] == nums[i-1]) {
					continue;
				}

				List<Integer> comb = new ArrayList<Integer>();
				comb.add(nums[i]);
				res.add(comb);
			}

			return res;
		}

		if (k == n) {
			List<Integer> comb = new ArrayList<Integer>();
			
			for (int i = 0; i < n; i++) {
				comb.add(nums[i]);
			}

			res.add(comb);
			return res;
		}

		List<List<Integer>> list1 = combine(nums, n-1, k);
		List<List<Integer>> list2 = combine(nums, n-1, k-1);

		res.addAll(list1);
		for (List<Integer> comb: list2) {
			comb.add(nums[n-1]);
			if (!res.contains(comb)) {
				res.add(comb);
			}
		}

		return res;
	}
}
