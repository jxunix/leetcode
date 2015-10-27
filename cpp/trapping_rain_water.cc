/*
 * Filename: trapping_rain_water.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 26 Jul 2015 11:07:31 AM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		int trap(vector<int>& height) {
			if (!height.size()) {
				return 0;
			}

			vector<int>::size_type i = 0;
			vector<int>::size_type j = height.size() - 1;
			int secH = 0;
			int res = 0;

			while (i < j) {
				if (height[i] < height[j]) {
					secH = max(secH, height[i]);
					res += secH - height[i];
					i++;
				} else {
					secH = max(secH, height[j]);
					res += secH - height[j];
					j--;
				}
			}

			return res;
		}
};
