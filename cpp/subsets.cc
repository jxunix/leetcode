/*
 * Filename: subsets.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 01 Aug 2015 08:53:54 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<int> > subsets(
				vector<int>& nums)
		{
			vector<vector<int> > res;

			if (!nums.size())
			{
				return res;
			}

			vector<int> sub;
			res.push_back(sub);
			sort(nums.begin(), nums.end());
			subsets_aux(nums, -1, res, sub);

			return res;
		}

	private:
		void subsets_aux(
				vector<int>& nums,
				int i,
				vector<vector<int> >& res,
				vector<int>& sub)
		{
			for (vector<int>::size_type j = i+1; j < nums.size(); j++)
			{
				sub.push_back(nums[j]);
				res.push_back(sub);
				subsets_aux(nums, j, res, sub);
				sub.pop_back();
			}
		}
};
