/*
 * Filename: search_insert_position.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 25 Jul 2015 01:13:02 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int searchInsert(vector<int>& nums, int target) {
			if (nums.size() == 1) {
				return nums[0] >= target ? 0 : 1;
			}

			if (target < nums[0]) {
				return 0;
			} else if (target > nums[nums.size() - 1]) {
				return nums.size();
			}

			int stt = 0;
			int end = nums.size() - 1;
			int mid = -1;

			while (stt <= end) {
				mid = (stt + end) / 2;

				if (nums[mid] == target) {
					return mid;
				} else if (mid && nums[mid - 1] < target && nums[mid] > target) {
					return mid;
				} else if (nums[mid] > target) {
					end = mid - 1;
				} else {
					stt = mid + 1;
				}
			}

			return mid;
		}
};
