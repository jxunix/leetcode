/*
 * Filename: rotate_array.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:24:04 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		void rotate(vector<int>& nums, int k) {
			if (nums.empty())
			{
				return;
			}

			int n = nums.size();
			k %= n;

			if (!k)
			{
				return;
			}

			reverse(nums, 0, n-k-1);
			reverse(nums, n-k, n-1);
			reverse(nums, 0, n-1);
		}

	private:
		void reverse(
				vector<int>& nums,
				int i,
				int j)
		{
			while (i < j)
			{
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
};
