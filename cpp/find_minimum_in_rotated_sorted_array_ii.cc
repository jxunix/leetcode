/*
 * Filename: find_minimum_in_rotated_sorted_array.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 07 Aug 2015 06:36:59 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int findMin(vector<int>& nums)
		{
			if (nums.empty())
			{
				return 0;
			}

			for (vector<int>::size_type i = 0; i < nums.size(); i++)
			{
				if (i && nums[i] < nums[i-1])
				{
					return nums[i];
				}
			}

			return nums[0];
		}
};
