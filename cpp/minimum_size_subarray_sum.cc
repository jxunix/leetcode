/*
 * Filename: minimum_size_subarray_sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 01:07:35 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int minSubArrayLen(int s, vector<int>& nums) {
			if (nums.empty())
			{
				return 0;
			}

			int i = 0;
			int j = 0;
			int sum = 0;
			int res = nums.size();

			while (j < nums.size())
			{
				sum += nums[j++];

				if (sum >= s)
				{
					while (sum >= s)
					{
						sum -= nums[i++];
					}

					sum += nums[--i];
					res = min(res, j-i);
				}
			}

			if (sum < s)
			{
				return 0;
			}

			return res;
		}
};
