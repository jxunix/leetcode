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

		int min = Integer.MAX_VALUE;
		int max = 0;
		int tmpIdx = -1;
		int minIdx = -1;
		int maxIdx = -1;

		for (int i = 0; i < prices.length; i++) {
			int n = prices[i];

			if (n < min) {
				min = n;
				tmpIdx = i;
			}

			if (n - min > max) {
				max = n - min;
				minIdx = tmpIdx;
				maxIdx = i;
			}
		}

		if (maxIdx == -1) {
			return 0;
		}

		int mmin = Integer.MAX_VALUE;
		int mmax = 0;
		for (int i = maxIdx; i >= minIdx; i--) {
			mmin = Math.min(mmin, prices[i]);
			mmax = Math.max(mmax, prices[i] - mmin);
		}

		int mmmin = Integer.MAX_VALUE;
		int mmmax = 0;
		for (int i = 0; i < minIdx; i++) {
			mmmin = Math.min(mmmin, prices[i]);
			mmmax = Math.max(mmmax, prices[i] - mmmin);
		}

		int mmmmin = Integer.MAX_VALUE;
		int mmmmax = 0;
		for (int i = maxIdx + 1; i < prices.length; i++) {
			mmmmin = Math.min(mmmmin, prices[i]);
			mmmmax = Math.max(mmmmax, prices[i] - mmmmin);
		}

		return max + Math.max(mmax, Math.max(mmmax, mmmmax));
	}
}
