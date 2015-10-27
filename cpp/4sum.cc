/*
 * Filename: 4sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 24 Jul 2015 02:06:00 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<vector<int> > fourSum(vector<int>& nums, int target) {
			vector<vector<int> > res;
			sort(nums.begin(), nums.end());

			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				if (i && nums[i] == nums[i-1]) {
					continue;
				}

				for (vector<int>::size_type j = i+1; j < nums.size(); j++) {
					if (j-i-1 && nums[j] == nums[j-1]) {
						continue;
					}

					int k = j+1;
					int l = nums.size() - 1;

					while (k < l) {
						if (k-j-1 && nums[k] == nums[k-1]) {
							k++;
							continue;
						}

						if (l < nums.size() - 1 && nums[l] == nums[l+1]) {
							l--;
							continue;
						}

						int sum = nums[i] + nums[j] + nums[k] + nums[l];
						if (sum == target) {
							vector<int> ans;
							ans.push_back(nums[i]);
							ans.push_back(nums[j]);
							ans.push_back(nums[k]);
							ans.push_back(nums[l]);
							res.push_back(ans);
							k++;
							l--;
						} else if (sum > target) {
							l--;
						} else {
							k++;
						}
					}
				}
			}

			return res;
		}
};
