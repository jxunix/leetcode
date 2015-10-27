/*
 * Filename: search_for_a_range.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 25 Jul 2015 01:00:55 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<int> searchRange(vector<int>& nums, int target) {
			vector<int> res;

			if (nums.size() == 1) {
				if (nums[0] == target) {
					res.push_back(0);
					res.push_back(0);
					return res;
				} else {
					res.push_back(-1);
					res.push_back(-1);
					return res;
				}
			}

			int left = left_binary_search(nums, target);
			if (left == -1) {
				res.push_back(-1);
				res.push_back(-1);
				return res;
			}

			int right = right_binary_search(nums, target);
			res.push_back(left);
			res.push_back(right);
			return res;
		}

	private:
		int left_binary_search(vector<int>& nums, int target) {
			int stt = 0;
			int end = nums.size() -1;
			int mid = -1;

			while (stt <= end) {
				mid = (stt + end) / 2;

				if (nums[mid] == target) {
					if (!mid || (mid && nums[mid - 1] < target)) {
						return mid;
					} else {
						end = mid - 1;
					}
				} else if (nums[mid] > target) {
					end = mid - 1;
				} else {
					stt = mid + 1;
				}
			}

			return -1;
		}

		int right_binary_search(vector<int>& nums, int target) {
			int stt = 0;
			int end = nums.size() -1;
			int mid = -1;

			while (stt <= end) {
				mid = (stt + end) / 2;

				if (nums[mid] == target) {
					if (mid == nums.size() - 1 ||
							(mid != nums.size() - 1 && nums[mid + 1] > target)) {
						return mid;
					} else {
						stt = mid + 1;
					}
				} else if (nums[mid] > target) {
					end = mid - 1;
				} else {
					stt = mid + 1;
				}
			}

			return -1;
		}
};
