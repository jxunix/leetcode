/*
 * Filename: NumberofIslands.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 08 Jul 2015 04:34:52 PM EDT
 */

public class Solution {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int num = 0;
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0' || visited[i][j]) {
					continue;
				}

				num++;
				dfs(i, j, grid, visited);
			}
		}

		return num;
	}

	private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (grid[i][j] == '1' && !visited[i][j]) {
			visited[i][j] |= true;
			dfs(i, j-1, grid, visited);
			dfs(i, j+1, grid, visited);
			dfs(i-1, j, grid, visited);
			dfs(i+1, j, grid, visited);
		}
	}
}
