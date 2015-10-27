/*
 * Filename: first_missing_positive.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 26 Jul 2015 10:59:02 AM EDT
 */

#include <iostream>
#include <map>

using namespace std;

class Solution {
	public:
		int firstMissingPositive(vector<int>& nums) {
			map<int, int> map;

			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				map[nums[i]] = i;
			}

			vector<int>::size_type i = 1;
			while (true) {
				if (map.find(i) != map.end()) {
					i++;
				} else {
					return i;
				}
			}

			return i;
		}
};
