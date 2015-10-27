/*
 * Filename: subsets_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 04 Aug 2015 07:18:39 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<int> > subsetsWithDup(vector<int>& nums)
		{
			vector<vector<int> > res;

			if (nums.empty())
			{
				return res;
			}

			vector<int> v;
			res.push_back(v);
			sort(nums.begin(), nums.end());
			subset_with_dup_aux(nums, -1, res, v);

			return res;
		}

	private:
		void subset_with_dup_aux(
				vector<int>& nums,
				int i,
				vector<vector<int> >& res,
				vector<int>& v)
		{
			for (vector<int>::size_type j = i+1; j < nums.size(); j++)
			{
				if (j-i-1 && nums[j] == nums[j-1])
				{
					continue;
				}

				v.push_back(nums[j]);
				res.push_back(v);
				subset_with_dup_aux(nums, j, res, v);
				v.pop_back();
			}
		}
};
