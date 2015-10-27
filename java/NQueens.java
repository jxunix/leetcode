/*
 * Filename: NQueens.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 13 May 2015 02:03:31 PM EDT
 */

public class Solution {
	public List<String[]> solveNQueens(int n) {
		if (n <= 0) {
			return null;
		}

		List<String[]> res = new ArrayList<String[]>();
		int[] bd = new int[n];
		solveNQueensAux(n, bd, res);
		return res;
	}

	private void solveNQueensAux(int n, int[] bd, List<String[]> res) {
		int i = 0;
		int j = 0;

		while (true) {
			if (j == n) {
				if (i > 0) {
					i--;
					j = bd[i] + 1;
				} else {
					return;
				}
			} else {
				if (test(bd, i, j)) {
					int temp = bd[i];
					bd[i] = j;
					if (i == n-1) {
						save(bd, res);
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

	private void save(int[] bd, List<String[]> res) {
		String[] strs = new String[bd.length];

		for (int i = 0; i < bd.length; i++) {
			strs[i] = "";
			for (int j = 0; j < bd.length; j++) {
				if (j == bd[i]) {
					strs[i] += "Q";
				} else {
					strs[i] += ".";
				}
			}
		}

		res.add(strs);
	}
}
