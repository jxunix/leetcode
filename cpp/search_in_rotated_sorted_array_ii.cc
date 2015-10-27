/*
 * Filename: search_in_rotated_sorted_array_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 02 Aug 2015 09:09:43 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		bool search(vector<int>& nums, int target) {
			if (nums.size() == 1) {
				return nums[0] == target ? true : false;
			}

			int len = nums.size();
			int offset = 0;
			int stt = 0;
			int end = nums.size() - 1;
			int mid = -1;

			for (int i = 1; i < len; i++) {
				if (nums[i] < nums[i-1]) {
					offset = i;
				}
			}

			while (stt <= end) {
				mid = (stt + end) / 2;
				int idx = (mid + offset) % len;
				
				if (nums[idx] == target) {
					return true;
				} else if (nums[idx] > target) {
					end = mid - 1;
				} else {
					stt = mid + 1;
				}
			}

			return false;
		}
};
