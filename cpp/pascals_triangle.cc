/*
 * Filename: pascals_triangle.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 04 Aug 2015 07:28:51 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<vector<int> > generate(int numRows)
		{
			vector<vector<int> > res;
			generate_aux(numRows, res);
			return res;
		}

	private:
		void generate_aux(
				int n,
				vector<vector<int> >& res)
		{
			if (!n) {
				return;
			}

			if (n == 1) {
				vector<int> v (1,1);
				res.push_back(v);
				return;
			}

			generate_aux(n-1, res);
			vector<int> last = res.back();
			vector<int> v (last.size() + 1, 1);

			for (int i = 1; i < last.size(); i++)
			{
				v[i] = last[i] + last[i-1];
			}

			res.push_back(v);
		}
};
