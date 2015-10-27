/*
 * Filename: contains_duplicate.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:40:34 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		bool containsDuplicate(vector<int>& nums) {
			if (nums.size() <= 1)
			{
				return false;
			}

			unordered_set<int> set;

			for (auto i = 0; i < nums.size(); i++)
			{
				if (set.find(nums[i]) != set.end())
				{
					return true;
				}
				else
				{
					set.insert(nums[i]);
				}
			}

			return false;
		}
};
