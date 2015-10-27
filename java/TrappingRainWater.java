/*
 * Filename: TrappingRainWater.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 09 Apr 2015 11:06:14 AM EDT
 */

public class Solution {
	public int trap(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}

		int trap = 0;
		int peak = -1;
		int area = 0;

		for (int i = 0; i < A.length; i++) {
			if (isPeak(A, i)) {
				if (peak == -1) {
					peak = i;
				} else if (A[i] >= A[peak]) {
					trap += area;
					area = 0;
					peak = i;
				} else {
					area += Math.max(0, A[peak] - A[i]);
				}
			} else {
				if (peak != -1) {
					area += Math.max(0, A[peak] - A[i]);
				}
			}
		}

		peak = A.length;
		area = 0;

		for (int i = A.length - 1; i >= 0; i--) {
			if (isPeak(A, i)) {
				if (peak == A.length) {
					peak = i;
				} else if (A[i] > A[peak]) {
					trap += area;
					area = 0;
					peak = i;
				} else {
					area += Math.max(0, A[peak] - A[i]);
				}
			} else {
				if (peak != A.length) {
					area += Math.max(0, A[peak] - A[i]);
				}
			}
		}

		return trap;
	}

	private boolean isPeak(int[] A, int i) {
		return (i == 0 && A[i] >= A[i+1]) ||
			(i == A.length - 1 && A[i] >= A[i-1]) ||
			(i != 0 && i != A.length -1 && A[i] >= A[i-1] && A[i] >= A[i+1]);
	}
}
