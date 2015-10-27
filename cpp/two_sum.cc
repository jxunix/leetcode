/*
 * Filename: two_sum.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:01:12 AM EDT
 */

#include <iostream>
using namespace std;

class Solution
{
	public:
		vector<int> twoSum(vector<int>& nums, int target) {
			vector<int> res;
			map<int, int> map;

			for (int i = 0; i < nums.size(); i++) {
				int n = nums[i];
				int rest = target - n;

				if (map.find(rest) != map.end()) {
					res.push_back(map[rest] + 1);
					res.push_back(i+1);
					return res;
				}

				map[nums[i]] = i;
			}

			return res;
		}
};
