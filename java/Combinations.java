/*
 * Filename: Combinations.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 21 May 2015 07:50:03 PM EDT
 */

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (n <= 0 || k <= 0) {
			return res;
		}

		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				List<Integer> comb = new ArrayList<Integer>();
				comb.add(i);
				res.add(comb);
			}

			return res;
		}

		if (k == n) {
			List<Integer> comb = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				comb.add(i);
			}
			res.add(comb);

			return res;
		}

		List<List<Integer>> list1 = combine(n-1, k);
		List<List<Integer>> list2 = combine(n-1, k-1);

		res.addAll(list1);
		for (List<Integer> comb: list2) {
			comb.add(n);
			res.add(comb);
		}

		return res;
	}
}
