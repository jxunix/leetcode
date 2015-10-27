/*
 * Filename: 3sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 08:48:43 PM EDT
 */

#include <algorithm>
#include <iostream>
#include <map>

using namespace std;

class Solution {
	public:
		vector<vector<int> > threeSum(vector<int>& nums) {
			sort(nums.begin(), nums.end());
			map<int, int> map;
			vector<vector<int> > res;

			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				map[nums[i]] = i;
			}

			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				if (i && nums[i] == nums[i-1]) {
					continue;
				}

				for (vector<int>::size_type j = i+1; j < nums.size(); j++) {
					if (j-i-1 && nums[j] == nums[j-1]) {
						continue;
					}

					int c = - nums[i] - nums[j];

					if (map.find(c) != map.end()) {
						int pc = map[c];

						if (pc > j) {
							vector<int> list;
							list.push_back(nums[i]);
							list.push_back(nums[j]);
							list.push_back(c);
							res.push_back(list);
						}
					}
				}
			}

			return res;
		}
};
