/*
 * Filename: DungeonGame.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 03:20:32 PM EDT
 */

public class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		int[][] h = new int[m][n];
		h[m-1][n-1] = Math.max(1 - dungeon[m-1][n-1], 1);

		for (int i = m-2; i >= 0; i--) {
			h[i][n-1] = Math.max(h[i+1][n-1] - dungeon[i][n-1], 1);
		}

		for (int j = n-2; j >= 0; j--) {
			h[m-1][j] = Math.max(h[m-1][j+1] - dungeon[m-1][j], 1);
		}

		for (int i = m-2; i >= 0; i--) {
			for (int j = n-2; j >= 0; j--) {
				int down = Math.max(h[i+1][j] - dungeon[i][j], 1);
				int right = Math.max(h[i][j+1] - dungeon[i][j], 1);
				h[i][j] = Math.min(right, down);
			}
		}

		return h[0][0];
	}
}
