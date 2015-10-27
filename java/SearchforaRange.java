/*
 * Filename: SearchforaRange.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 01:47:58 PM EDT
 */

public class Solution {
	public int[] searchRange(int[] A, int target) {
		int[] ret = new int[]{ -1, -1 };
		int n = A.length;

		if (n == 0) {
			return ret;
		}

		if (n == 1) {
			if (A[0] == target) {
				ret[0] = 0;
				ret[1] = 0;
				return ret;
			} else {
				return ret;
			}
		}

		int start = 0;
		int end = n-1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				if (mid == 0 || A[mid - 1] != target) {
					ret[0] = mid;
					break;
				} else {
					end = mid - 1;
				}
			}
		}

		start = 0;
		end = n-1;

		while (start <= end) {
			mid = (start + end) / 2;
			if (A[mid] < target) {
				start = mid + 1;
			} else if (A[mid] > target) {
				end = mid - 1;
			} else {
				if (mid == n-1 || A[mid+1] != target) {
					ret[1] = mid;
					break;
				} else {
					start = mid + 1;
				}
			}
		}

		return ret;
	}
}
