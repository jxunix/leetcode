/*
 * Filename: remove_duplicates_from_sorted_array_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 02 Aug 2015 08:44:44 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int removeDuplicates(vector<int>& nums)
		{
			if (nums.size() < 3)
			{
				return nums.size();
			}

			int i = 2;
			int res = 1;

			while (i < nums.size())
			{
				if (nums[res] - nums[i] || nums[res - 1] - nums[i])
				{
					nums[++res] = nums[i];
				}

				i++;
			}

			return res + 1;
		}
};
