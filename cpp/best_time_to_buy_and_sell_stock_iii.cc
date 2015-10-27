/*
 * Filename: best_time_to_buy_and_sell_stock_iii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 05 Aug 2015 06:46:03 PM EDT
 */

#include <climits>
#include <iostream>

using namespace std;

class Solution {
	public:
		int maxProfit(vector<int>& prices)
		{
			if (prices.empty() || prices.size() == 1)
			{
				return 0;
			}

			int n = prices.size();
			vector<int> first (n);
			vector<int> second (n);

			int mini = prices[0];
			int maxi = prices[n-1];
			int res = 0;

			for (int i = 1; i < n; i++) {
				mini = min(mini, prices[i]);
				first[i] = max(first[i-1], prices[i] - mini);
			}

			for (int i = n-2; i >= 0; i--) {
				maxi = max(maxi, prices[i]);
				second[i] = max(second[i+1], maxi - prices[i]);
			}

			for (int i = 0; i < n; i++) {
				res = max(res, first[i] + second[i]);
			}

			return res;
		}
};
