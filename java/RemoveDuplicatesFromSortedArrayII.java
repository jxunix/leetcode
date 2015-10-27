/*
 * Filename: RemoveDuplicatesFromSortedArrayII.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Mon 02 Mar 2015 07:58:19 PM EST
 */

public class Solution {
	public int removeDuplicates(int[] A) {
		int length = A.length;
		if (length < 3) return length;
		else {
			int curr = 2;
			int prev = 1;
			int res = 2;

			for (; curr < length; curr++) {
				if (A[curr] != A[prev] || A[curr] != A[prev-1]) {
					res++;
					A[++prev] = A[curr];
				}
			}

			return res;
		}
	}
}
