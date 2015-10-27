/*
 * Filename: CombinationSumIII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 13 Jul 2015 01:53:07 PM EDT
 */

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combinationSum3Aux(k, n, res, list, 0);
		return res;
	}

	private void combinationSum3Aux
			(int k, int n, List<List<Integer>> res, List<Integer> list, int i) {
		if (n < 0) {
			return;
		}

		if (i == k) {
			if (n == 0)	{
				List<Integer> list2 = new ArrayList<Integer>();
				list2.addAll(list);
				res.add(list2);
			}

			return;
		}

		int stt = 1;
		if (list.size() != 0) {
			stt += list.get(list.size() - 1);
		}

		for (int j = stt; j <= 9; j++) {
			list.add(j);
			combinationSum3Aux(k, n-j, res, list, i+1);
			list.remove(list.size() - 1);
		}
	}
}
