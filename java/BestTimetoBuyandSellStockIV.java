/*
 * Filename: BestTimetoBuyandSellStockIV.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 22 Jul 2015 12:46:48 PM EDT
 */

public class Solution {
	public int maxProfit(int k, int[] prices) {
		if (prices == null) {
			return 0;
		}

		int n = prices.length;
		if (n < 2 || k <= 0) {
			return 0;
		}

		if (k >= n / 2) {
			int res = 0;

			for (int i = 1; i < n; i++) {
				if (prices[i] - prices[i-1] > 0) {
					res += prices[i] - prices[i-1];
				}
			}

			return res;
		}

		int[][] local = new int[n][k+1];
		int[][] global = new int[n][k+1];

		for (int i = 1; i < n; i++) {
			int diff = prices[i] - prices[i-1];

			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
				global[i][j] = Math.max(global[i-1][j], local[i][j]);
			}
		}

		return global[n-1][k];
	}
}
