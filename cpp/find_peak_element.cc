/*
 * Filename: find_peak_element.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 14 Aug 2015 10:10:03 AM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int findPeakElement(vector<int>& nums) {
			if (nums.empty())
			{
				return 0;
			}

			int stt = 0;
			int end = nums.size() - 1;
			int mid = -1;

			while (stt < end) {
				mid = (stt + end) / 2;

				if (nums[mid] > nums[mid + 1])
				{
					end = mid;
				}
				else
				{
					stt = mid + 1;
				}
			}

			return stt;
		}
};
