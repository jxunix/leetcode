/*
 * Filename: MedianofTwoSortedArrays.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Tue 03 Mar 2015 06:49:59 PM EST
 */

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int k = A.length + B.length;
		if (k % 2 == 0) {
			return (findKth(A, 0, B, 0, k/2) + findKth(A, 0, B, 0, k/2+1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, k/2+1);
		}
	}

	private double findKth(int[] A, int a, int[] B, int b, int k) {
		if (a >= A.length) {
			return B[b+k-1];
		}
		if (b >= B.length) {
			return A[a+k-1];
		}

		if (k == 1) {
			return Math.min(A[a], B[b]);
		}

		int keyA = a+k/2-1 < A.length ? A[a+k/2-1] : Integer.MAX_VALUE;
		int keyB = b+k/2-1 < B.length ? B[b+k/2-1] : Integer.MAX_VALUE; 

		if (keyA < keyB) {
			return findKth(A, a + k/2, B, b, k - k/2);
		} else {
			return findKth(A, a, B, b + k/2, k - k/2);
		}
	}
}
