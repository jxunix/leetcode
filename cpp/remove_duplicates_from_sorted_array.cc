/*
 * Filename: remove_duplicates_from_sorted_array.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 24 Jul 2015 02:21:06 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int removeDuplicates(vector<int>& nums) {
			if (nums.size() < 2) {
				return nums.size();
			}

			int res = 0;
			for (vector<int>::size_type i = 0; i < nums.size(); i++) {
				if (i && nums[i] == nums[i-1]) {
					continue;
				}

				nums[res++] = nums[i];
			}

			return res;
		}
};
