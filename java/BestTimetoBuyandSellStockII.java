/*
 * Filename: BestTimetoBuyandSellStockII.java
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 29 Jun 2015 10:43:59 AM EDT
 */

public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i-1];
			if (diff > 0) {
				res += diff;
			}
		}

		return res;
	}
}
