/*
 * Filename: FirstMissingPositive.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Apr 2015 11:49:28 PM EDT
 */

public class Solution {
	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		int max = A[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
			if (A[i] > max) {
				max = A[i];
			}
		}

		for (int i = 1; i <= max; i++) {
			if (!map.containsKey(i)) {
				return i;
			}
		}

		return max + 1;
	}
}
