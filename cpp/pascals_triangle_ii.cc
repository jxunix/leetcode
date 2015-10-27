/*
 * Filename: pascals_triangle_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Wed 05 Aug 2015 06:15:34 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<int> getRow(int rowIndex) {
			vector<int> res;
			get_row_aux(rowIndex, res);
			return res;
		}

	private:
		void get_row_aux(
				int n,
				vector<int>& res)
		{
			if (!n)
			{
				res.push_back(1);
				return;
			}
			else if (n == 1)
			{
				res.push_back(1);
				res.push_back(1);
				return;
			}

			get_row_aux(n-1, res);

			for (vector<int>::size_type i = res.size() - 1; i > 0; i--)
			{
				res[i] += res[i-1];
			}

			res.push_back(1);
		}
};
