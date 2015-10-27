/*
 * Filename: WordSearch.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 22 May 2015 01:43:10 PM EDT
 */

public class Solution {
	public boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (existAux(board, word, 0, i, j, visited)) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean existAux(char[][] board, String word, int k, int i, int j, boolean[][] visited) {
		if (k == word.length()) {
			return true;
		}

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}

		if (visited[i][j]) {
			return false;
		}

		if (board[i][j] != word.charAt(k)) {
			return false;
		}

		visited[i][j] = true;
		boolean res = existAux(board, word, k+1, i-1, j, visited)
			|| existAux(board, word, k+1, i+1, j, visited)
			|| existAux(board, word, k+1, i, j+1, visited)
			|| existAux(board, word, k+1, i, j-1, visited);
		visited[i][j] = false;
		return res;
	}
}
