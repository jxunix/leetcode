/*
 * Filename: NextPermutation.java
 * Author: Jun Xu
 * Email: junx@bu.edu
 * Created Time: Fri 20 Mar 2015 05:59:58 PM EDT
 */

public class Solution {
	public void solveSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return;
		}

		solveSudokuAux(board, 0, 0);
		return;
	}

	public static void solveSudokuAux(char[][] board, int i, int j) {
		if (j == 9) {
			j = 0;
			i++;
		}

		if (i == 9) {
			return;
		}

		int n = board.length;
		char[] token = new char[]{ '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		if (board[i][j] == '.') {
			int iBlock = i / 3;
			int jBlock = j / 3;

			for (int k = 3 * iBlock; k < 3 * (iBlock + 1); k++) {
				for (int l = 3 * jBlock; l < 3 * (jBlock + 1); l++) {
					if (board[k][l] >= '1' && board[k][l] <= '9') {
						token[board[k][l] - '1'] = '0';
					}
				}
			}

			for (int k = 0; k < n; k++) {
				if (k != i && board[k][j] >= '1' && board[k][j] <= '9') {
					token[board[k][j] - '1'] = '0';
				}
				if (k != j && board[i][k] >= '1' && board[i][k] <= '9') {
					token[board[i][k] - '1'] = '0';
				}
			}

			for (int k = 0; k < token.length; k++) {
				if (token[k] != '0') {
					board[i][j] = token[k];
					solveSudokuAux(board, i, j+1);
					if (isFull(board)) {
						return;
					}
					board[i][j] = '.';
				}
			}
		} else {
			solveSudokuAux(board, i, j+1);
		}

		return;
	}

	private boolean isFull(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] > '9' || board[i][j] < '1') {
					return false;
				}
			}
		}
		return true;
	}
}
