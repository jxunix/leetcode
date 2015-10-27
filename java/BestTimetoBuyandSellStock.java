/*
 * Filename: BestTimetoBuyandSellStock.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 09:37:39 AM EDT
 */

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		if (prices.length == 2) {
			return Math.max(0, prices[1] - prices[0]);
		}

		int min = Integer.MAX_VALUE;
		int max = 0;
		int diff;

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i] - min);
		}

		return max;
	}
}
