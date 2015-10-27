/*
 * Filename: container_with_most_water.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 08:38:25 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		int maxArea(vector<int>& height) {
			int i = 0;
			int j = height.size() - 1;
			int res = 0;

			while (i < j) {
				if (height[i] > height[j]) {
					res = max(res, (j-i) * height[j]);
					j--;
				} else {
					res = max(res, (j-i) * height[i]);
					i++;
				}
			}

			return res;
		}
};
