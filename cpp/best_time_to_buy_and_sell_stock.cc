/*
 * Filename: best_time_to_buy_and_sell_stock.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 05 Aug 2015 06:40:12 PM EDT
 */

#include <iostream>
#include <climits>

using namespace std;

class Solution {
	public:
		int maxProfit(vector<int>& prices)
		{
			if (prices.empty())
			{
				return 0;
			}

			int mini = INT_MAX;
			int res = 0;

			for (vector<int>::size_type i = 0; i < prices.size(); i++)
			{
				mini = min(mini, prices[i]);
				res = max(res, prices[i] - mini);
			}

			return res;
		}
};
