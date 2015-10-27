/*
 * Filename: SearchinRotatedSortedArray.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 01:24:12 PM EDT
 */

public class Solution {
	public int search(int[] A, int target) {
		int n = A.length;

		if (n == 0) {
			return -1;
		}

		if (n == 1) {
			if (A[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		int i = 1;
		while (i < n && A[i-1] <= A[i]) {
			i++;
		}

		int head = 0;
		int tail = n - 1;
		int mid;
		int val;
		
		while (head <= tail) {
			mid = (head + tail) / 2;
			val = A[(mid + i) % n];
			if (val == target) {
				return mid;
			} else if (val < target) {
				head = mid + 1;
			} else {
				tail = mid - 1;
			}
		}

		return -1;
	}
}
