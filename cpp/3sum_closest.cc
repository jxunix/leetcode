/*
 * Filename: 3sum_closest.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 24 Jul 2015 01:32:24 PM EDT
 */

#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int threeSumClosest(vector<int>& nums, int target) {
			sort(nums.begin(), nums.end());
			int diff = INT_MAX;
			int res;

			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				if (i && nums[i] == nums[i-1]) {
					continue;
				}

				int j = i+1;
				int k = nums.size() - 1;

				while (j < k) {
					if (j-i-1 && nums[j] == nums[j-1]) {
						j++;
						continue;
					}

					if (k < nums.size() - 1 && nums[k] == nums[k+1]) {
						k--;
						continue;
					}

					int sum = nums[i] + nums[j] + nums[k];

					if (abs(sum - target) < diff) {
						diff = abs(sum - target);
						res = sum;
					}

					if (sum == target) {
						return target;
					} else if (sum > target) {
						k--;
					} else {
						j++;
					}
				}
			}

			return res;
		}
};
