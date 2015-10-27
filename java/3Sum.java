/*
 * Filename: 3Sum.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 03:56:43 PM EDT
 */

public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);

		List<List<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		int n = num.length;
		for (int i = 0; i < n - 2; i++) {
			if (i > 0 && num[i] == num[i-1]) {
				continue;
			}

			int a = num[i];
			int start = i+1;
			int end = n-1;

			while (start < end) {
				int b = num[start];
				int c = num[end];

				if (a+b+c == 0) {
					if (start != i+1 && num[start] == num[start-1]) {
						start++;
						continue;
					}

					if (end != n-1 && num[end] == num[end+1]) {
						end--;
						continue;
					}

					List<Integer> tuple = new ArrayList<Integer>();
					tuple.add(a);
					tuple.add(b);
					tuple.add(c);
					ret.add(tuple);
					start++;
					end--;
				} else if (a+b+c > 0) {
					end--;
				} else {
					start++;
				}
			}
		}

		return ret;
	}
}
