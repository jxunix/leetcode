/*
 * Filename: jump_game_ii.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 26 Jul 2015 11:21:41 AM EDT
 */

#include <iostream>
#include <climits>

using namespace std;

class Solution {
	public:
		int jump(vector<int>& nums) {
			if (nums.size() < 2) {
				return 1;
			}

			int stt = 0;
			int end = 0;
			int eend = 0;
			int cnt = 0;

			while (end < nums.size() - 1) {
				eend = end;
				cnt++;

				for (vector<int>::size_type i = stt; i <= end; i++) {
					if (i + nums[i] >= n-1) {
						return cnt;
					}

					eend = max(eend, i + nums[i]);
				}

				stt = end + 1;
				end = eend;
			}
		}
};
