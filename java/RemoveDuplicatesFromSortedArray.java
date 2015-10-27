/*
 * Filename: RemoveDuplicatesFromSortedArray.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Mon 02 Mar 2015 07:48:41 PM EST
 */

public class Solution {
	public int removeDuplicates(int[] A) {
		int length = A.length;
		if (length == 0) return 0;
		else if (length == 1) return 1;
		else {
			int prev = 0;
			int curr = 1;
			int res = 1;

			for (; curr < length; curr++) {
				if (A[prev] != A[curr])	{
					res++;
					A[++prev] = A[curr];
				}
			}

			return res;
		}
	}
}
