/*
 * Filename: Searcha2DMatrix.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 20 May 2015 04:26:42 PM EDT
 */

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
			return false;
		}

		int i = bs1(matrix, target);
		if (target == matrix[i][0] || target == matrix[i][n-1]) {
			return true;
		}

		int j = bs2(matrix[i], target);
		if (j == -1) {
			return false;
		}
		
		return true;
	}

	private int bs1(int[][] matrix, int target) {
		if (matrix.length == 1) {
			return 0;
		}

		int stt = 0;
		int end = matrix.length - 1;
		int mid = 0;

		while (stt <= end) {
			mid = (stt + end) / 2;
			if (matrix[mid][0] == target) {
				return mid;
			} else if (matrix[mid][0] < target) {
				if (mid < matrix.length - 1 && matrix[mid+1][0] > target) {
					return mid;
				} else {
					stt = mid + 1;
				}
			} else {
				end = mid - 1;
			}
		}

		return mid;
	}

	private int bs2(int[] A, int target) {
		if (A.length == 1) {
			if (A[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}

		int stt = 0;
		int end = A.length - 1;
		int mid;

		while (stt <= end) {
			mid = (stt + end) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				stt = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return -1;
	}
}
