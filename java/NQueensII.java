/*
 * Filename: NQueens.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 13 May 2015 02:03:31 PM EDT
 */

public class Solution {
	public int totalNQueens(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] bd = new int[n];
		return solveNQueensAux(n, bd);
	}

	private int solveNQueensAux(int n, int[] bd) {
		int i = 0;
		int j = 0;
		int res = 0;

		while (true) {
			if (j == n) {
				if (i > 0) {
					i--;
					j = bd[i] + 1;
				} else {
					return res;
				}
			} else {
				if (test(bd, i, j)) {
					int temp = bd[i];
					bd[i] = j;
					if (i == n-1) {
						res++;
						bd[i] = temp;
						j++;
					} else {
						i++;
						j = 0;
					}
				} else {
					j++;
				}
			}
		}
	}

	private boolean test(int[] bd, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (bd[k] == j || Math.abs(i-k) == Math.abs(j - bd[k])) {
				return false;
			}
		}

		return true;
	}
}
