/*
 * Filename: ValidSudoku.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Sun 22 Mar 2015 04:01:16 PM EDT
 */

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		int len = board.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (board[i][j] <= '9' && board[i][j] >= '1') {
					for (int k = 0; k < len; k++) {
						if (k != j && board[i][k] == board[i][j]) {
							return false;
						}

						if (k != i && board[k][j] == board[i][j]) {
							return false;
						}

						int iBlock = i / 3;
						int jBlock = j / 3;

						for (int m = 3 * iBlock; m < 3 * (iBlock + 1); m++) {
							for (int n = 3 * jBlock; n < 3 * (jBlock + 1); n++) {
								if (m != i && n != j && board[m][n] == board[i][j]) {
									return false;
								}
							}
						}
					}
				}
			}
		}

		return true;
	}
}
