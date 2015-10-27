/*
 * Filename: summary_ranges.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 03:45:19 PM EDT
 */

#include <iostream>
#include <iterator>
#include <map>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<string> summaryRanges(vector<int>& nums) {
			vector<string> res;

			if (nums.empty())
			{
				return res;
			}

			map<int, int> mapping;
			int val;

			for (auto i = 0; i < nums.size(); i++)
			{
				if (i && nums[i] == nums[i-1] + 1)
				{
					mapping[val] = nums[i];
				}
				else
				{
					val = nums[i];
					mapping[val] = val;
				}
			}

			for (auto it = mapping.begin(); it != mapping.end(); it++)
			{
				string s;

				if (it->first == it->second)
				{
					s = to_string(it->first);
				}
				else
				{
					s = to_string(it->first) + "->" + to_string(it->second);
				}

				res.push_back(s);
			}
		}
};
