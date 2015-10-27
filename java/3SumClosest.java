/*
 * Filename: 3SumClosest.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Wed 11 Mar 2015 04:45:05 PM EDT
 */

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);

		int ret = (target > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE + 1;

		int n = num.length;
		for (int i = 0; i < n-2; i++) {
			if (i > 0 && num[i] == num[i-1]) {
				continue;
			}

			int a = num[i];
			int start = i+1;
			int end = n-1;

			while(start < end) {
				if (start != i+1 && num[start] == num[start-1]) {
					start++;
					continue;
				}

				if (end != n-1 && num[end] == num[end+1]) {
					end--;
					continue;
				}

				int b = num[start];
				int c = num[end];

				int sum = a + b + c;
				if (Math.abs(sum - target) < Math.abs(ret - target)) {
					ret = sum;
				}
				
				if (sum > target) {
					end--;
				} else if (sum < target) {
					start++;
				} else {
					return target;
				}
			}
		}

		return ret;
	}
}
