
/*
 * Filename: combination_sum_iii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 03:31:40 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<vector<int>> combinationSum3(int k, int n) {
			vector<vector<int> > res;
			vector<int> tuple;
			combination_sum3_aux(0, k, n, res, tuple);
			return res;
		}

	private:
		void combination_sum3_aux(
				int i,
				int k,
				int n,
				vector<vector<int> >& res,
				vector<int>& tuple)
		{
			if (k < 0 || n < 0)
			{
				return;
			}

			if (!k && !n)
			{
				res.push_back(tuple);
				return;
			}

			for (int j = i+1; j <= 9; j++)
			{
				tuple.push_back(j);
				combination_sum3_aux(j, k-1, n-j, res, tuple);
				tuple.pop_back();
			}
		}
};
