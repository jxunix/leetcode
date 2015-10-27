/*
 * Filename: next_permutation.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 24 Jul 2015 02:42:05 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		void nextPermutation(vector<int>& nums) {
			vector<int>::size_type i = nums.size() - 2;
			while (i >= 0 && nums[i] >= nums[i+1]) {
				i--;
			}

			if (i+1) {
				vector<int>::size_type j = nums.size() - 1;
				while (j > i && nums[j] <= nums[i]) {
					j--;
				}

				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;

				i++;
				j = nums.size() - 1;
				while (j > i) {
					tmp = nums[j];
					nums[j] = nums[i];
					nums[i] = tmp;
					i++;
					j--;
				}
			} else {
				for (vector<int>::size_type j = 0; j < nums.size() / 2; j++) {
					int tmp = nums[j];
					nums[j] = nums[nums.size() - j - 1];
					nums[nums.size() - j - 1] = tmp;
				}
			}
		}
};
