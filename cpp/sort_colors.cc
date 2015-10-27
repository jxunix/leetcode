/*
 * Filename: sort_colors.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sat 01 Aug 2015 07:54:22 PM EDT
 */

#include <iterator>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		void sortColors(vector<int>& nums) {
			if (!nums.size()) {
				return;
			}

			int i = 0;
			int j = nums.size() - 1;

			while (i < j) {
				if (!nums[i]) {
					i++;
					continue;
				}

				if (nums[j]) {
					j--;
					continue;
				}

				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}

			j = nums.size() - 1;
			while (i < j) {
				if (nums[i] == 1) {
					i++;
					continue;
				}

				if (nums[j] == 2) {
					j--;
					continue;
				}

				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
};
