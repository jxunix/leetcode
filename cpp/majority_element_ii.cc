/*
 * Filename: majority_element_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:51:06 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		vector<int> majorityElement(vector<int>& nums) {
			vector<int> res;

			if (nums.empty())
			{
				return res;
			}

			int mode1 = 0;
			int mode2 = 0;
			int cnt1 = 0;
			int cnt2 = 0;

			for (auto i = 0; i < nums.size(); i++)
			{
				if (nums[i] == mode1)
				{
					cnt1++;
				}
				else if (nums[i] == mode2)
				{
					cnt2++;
				}
				else
				{
					if (cnt1 == 0)
					{
						mode1 = nums[i];
						cnt1 = 1;
					}
					else if (cnt2 == 0)
					{
						mode2 = nums[i];
						cnt2 = 1;
					}
					else
					{
						cnt1--;
						cnt2--;
					}
				}
			}

			cnt1 = 0;
			cnt2 = 0;

			for (auto i = 0; i < nums.size(); i++)
			{
				if (nums[i] == mode1)
				{
					cnt1++;
				}
				else if (nums[i] == mode2)
				{
					cnt2++;
				}
			}

			if (cnt1 * 3 > nums.size())
			{
				res.push_back(mode1);
			}

			if (cnt2 * 3 > nums.size())
			{
				res.push_back(mode2);
			}

			return res;
		}
};
