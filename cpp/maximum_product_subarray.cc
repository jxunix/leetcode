/*
 * Filename: maximum_product_subarray.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 07 Aug 2015 06:46:50 PM EDT
 */

#include <climits>
#include <iostream>

using namespace std;

class Solution {
	public:
		int maxProduct(vector<int>& nums) {
			if (nums.empty())
			{
				return 0;
			}

			int maxi = nums[0];
			int mini = nums[0];
			int res = nums[0];

			for (vector<int>::size_type i = 1; i < nums.size(); i++)
			{
				int a = maxi * nums[i];
				int b = mini * nums[i];
				maxi = max(nums[i], max(a, b));
				mini = min(nums[i], min(a, b));
				res = max(res, maxi);
			}

			return res;
		}
};
