/*
 * Filename: remove_element.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 24 Jul 2015 02:28:12 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int removeElement(vector<int>& nums, int val) {
			vector<int>::size_type i = 0;
			vector<int>::size_type j = nums.size() - 1;

			while (i < j+1) {
				if (nums[i] != val) {
					i++;
					continue;
				}

				if (nums[j] == val) {
					j--;
					continue;
				}

				nums[i++] = nums[j--];
			}

			return (int) j+1;
		}
};
