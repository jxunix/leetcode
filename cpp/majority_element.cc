/*
 * Filename: majority_element.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 12:04:55 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int majorityElement(vector<int>& nums) {
			int mode = nums[0];
			int cnt = 1;

			for (auto i = 1; i < nums.size(); i++)
			{
				if (nums[i] == mode)
				{
					cnt++;
				}
				else
				{
					cnt--;

					if (cnt == 0)
					{
						mode = nums[i];
						cnt = 1;
					}
				}
			}

			return mode;
		}
};
