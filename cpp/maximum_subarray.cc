/*
 * Filename: maximum_subarray.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 26 Jul 2015 01:06:50 PM EDT
 */

#include <climits>
#include <iostream>

using namespace std;

class Solution {
	public:
		int maxSubArray(vector<int>& nums) {
			int maxi = nums[0];
			int locMax = nums[0];

			for (vector<int>::size_type i = 1; i < nums.size(); i++) {
				locMax = max(locMax + nums[i], nums[i]);
				maxi = max(maxi, locMax);
			}

			return maxi;
		}
};
