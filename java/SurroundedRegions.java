/*
 * Filename: SurroundedRegions.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 01 Jul 2015 12:29:34 PM EDT
 */

public class Solution {
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'U';
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'U') {
				capture(i, 0, board);
			}

			if (board[i][n-1] == 'U') {
				capture(i, n-1, board);
			}
		}

		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'U') {
				capture(0, i, board);
			}

			if (board[m-1][i] == 'U') {
				capture(m-1, i, board);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'U') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private void capture(int x, int y, char[][] board) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		Queue<Pixel> queue = new LinkedList<Pixel>();
		queue.add(new Pixel(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Pixel p = queue.poll();
			board[p.x][p.y] = 'O';

			if (p.x > 0 && board[p.x-1][p.y] == 'U' && !visited[p.x-1][p.y]) {
				queue.add(new Pixel(p.x-1, p.y));
				visited[p.x-1][p.y] = true;
			}

			if (p.y < n-1 && board[p.x][p.y+1] == 'U' && !visited[p.x][p.y+1]) {
				queue.add(new Pixel(p.x, p.y+1));
				visited[p.x][p.y+1] = true;
			}

			if (p.x < m-1 && board[p.x+1][p.y] == 'U' && !visited[p.x+1][p.y]) {
				queue.add(new Pixel(p.x+1, p.y));
				visited[p.x+1][p.y] = true;
			}

			if (p.y > 0 && board[p.x][p.y-1] == 'U' && !visited[p.x][p.y-1]) {
				queue.add(new Pixel(p.x, p.y-1));
				visited[p.x][p.y-1] = true;
			}
		}
	}

	private class Pixel {
		int x;
		int y;

		public Pixel(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
