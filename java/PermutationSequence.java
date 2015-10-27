/*
 * Filename: PermutationSequence.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 18 May 2015 04:07:41 PM EDT
 */

public class Solution {
	public String getPermutation(int n, int k) {
		List<Integer> list = new ArrayList<Integer>();
		char[] seq = new char[n];
		k--;

		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		for (int i = n; i > 1; i--) {
			int fact = factorial(i-1);
			int m = k / fact;
			k = k % fact;
			seq[n-i] = (char) (list.remove(m) + '0');
		}

		seq[n-1] = (char) (list.remove(0) + '0');
		return String.valueOf(seq);
	}

	private int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}
}
