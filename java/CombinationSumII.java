/*
 * Filename: CombinationSumII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Apr 2015 11:38:45 PM EDT
 */

public class Solution {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> tuple = new ArrayList<Integer>();

		if (num == null || num.length == 0) {
			return ret;
		}

		Arrays.sort(num);

		combinationSum2Aux(num, target, tuple, ret, 0);
		return ret;
	}

	private void combinationSum2Aux(int[] num, int target, List<Integer> tuple, List<List<Integer>> ret, int bound) {
		if (target == 0) {
			ret.add(new ArrayList<Integer>(tuple));
			return;
		}

		if (target < 0) {
			return;
		}

		for (int i = bound; i < num.length; i++) {
			if (i != bound && num[i] == num[i-1]) {
				continue;
			}
			tuple.add(num[i]);
			combinationSum2Aux(num, target - num[i], tuple, ret, i+1);
			tuple.remove(tuple.size() - 1);
		}
	}
}
