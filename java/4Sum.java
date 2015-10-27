/*
 * Filename: 4Sum.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Thu 12 Mar 2015 03:36:24 PM EDT
 */

public class Solution {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);

		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		int n = num.length;
		for (int i = 0; i < n-3; i++) {
			if (i > 0 && num[i] == num[i-1]) {
				continue;
			}

			for (int j = i+1; j < n-2; j++) {
				if (j != i+1 && num[j] == num[j-1]) {
					continue;
				}

				int a = num[i];
				int b = num[j];
				int k = j+1;
				int l = n-1;

				while (k < l) {
					if (k != j+1 && num[k] == num[k-1]) {
						k++;
						continue;
					}
					
					if (l != n-1 && num[l] == num[l+1]) {
						l--;
						continue;
					}

					int c = num[k];
					int d = num[l];
					int sum = a + b + c + d;

					if (sum == target) {
						List<Integer> tuple = new ArrayList<Integer>();
						tuple.add(num[i]);
						tuple.add(num[j]);
						tuple.add(num[k]);
						tuple.add(num[l]);
						ret.add(tuple);
						k++;
						l--;
					} else if (sum < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}

		return ret;
	}
}
