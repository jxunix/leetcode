/*
 * Filename: contains_duplicate_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:46:34 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		bool containsNearbyDuplicate(vector<int>& nums, int k) {
			if (nums.size() <= 1)
			{
				return false;
			}

			map<int, int> mapping;

			for (auto i = 0; i < nums.size(); i++)
			{
				if (mapping.find(nums[i]) != mapping.end() && i - mapping[nums[i]] <= k)
				{
					return true;
				}
				else
				{
					mapping[nums[i]] = i;
				}
			}

			return false;
		}
};
