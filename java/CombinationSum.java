/*
 * Filename: NextPermutation.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 20 Mar 2015 05:59:58 PM EDT
 */

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> tuple = new ArrayList<Integer>();

		if (candidates == null || candidates.length == 0) {
			return ret;
		}

		Arrays.sort(candidates);
		combinationSumAux(candidates, target, tuple, ret, 0);
		return ret;
	}

	private void combinationSumAux(int[] candidates, int target, List<Integer> tuple, List<List<Integer>> ret, int bound) {
		if (target < 0) {
			return;
		}

		if (target == 0) {
			ret.add(new ArrayList<Integer>(tuple));
			return;
		}

		for (int i = bound; i < candidates.length; i++) {
			tuple.add(candidates[i]);
			combinationSumAux(candidates, target - candidates[i], tuple, ret, i);
			tuple.remove(tuple.size() - 1);
		}
	}
}
