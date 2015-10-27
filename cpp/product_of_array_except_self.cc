/*
 * Filename: product_of_array_except_self.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:30:54 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<int> productExceptSelf(vector<int>& nums) {
			if (nums.empty())
			{
				vector<int> res;
				return res;
			}

			int n = nums.size();
			vector<int> res (n);
			vector<int> forward (n, 1);
			vector<int> backward (n, 1);

			for (int i = 1; i < n; i++)
			{
				forward[i] = forward[i-1] * nums[i-1];
			}

			for (int i = n-2; i >= 0; i--)
			{
				backward[i] = backward[i+1] * nums[i+1];
			}

			for (int i = 0; i < n; i++)
			{
				res[i] = forward[i] * backward[i];
			}

			return res;
		}
};
