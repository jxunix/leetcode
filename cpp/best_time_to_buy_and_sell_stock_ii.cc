/*
 * Filename: best_time_to_buy_and_sell_stock_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 05 Aug 2015 06:43:32 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int maxProfit(vector<int>& prices) {
			if (prices.empty())
			{
				return 0;
			}

			int res = 0;

			for (vector<int>::size_type i = 1; i < prices.size(); i++)
			{
				if (prices[i] > prices[i-1])
				{
					res += prices[i] - prices[i-1];
				}
			}

			return res;
		}
};
