/*
 * Filename: SearchInsertPosition.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 03:44:12 PM EDT
 */

public class Solution {
	public int searchInsert(int[] A, int target) {
		int n = A.length;

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			if (A[0] >= target) {
				return 0;
			} else if (A[0] < target) {
				return 1;
			}
		}

		int start = 0;
		int end = n-1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[start] >= target) {
				return start;
			} else if (A[end] < target) {
				return end + 1;
			} else if (A[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return end;
	}
}
