/*
 * Filename: jump_game.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Mon 27 Jul 2015 12:01:38 PM EDT
 */

#include <iostream>
using namespace std;

class Solution {
	public:
		bool canJump(vector<int>& nums) {
			if (nums.size() < 2) {
				return true;
			}

			int stt = 0;
			int end = 0;
			
			while (end < nums.size() - 1) {
				int eend = end;

				for (vector<int>::size_type i = stt; i <= end; i++) {
					if (i + nums[i] >= nums.size() - 1) {
						return true;
					}

					eend = max(eend, i + nums[i]);
				}

				if (eend == end) {
					return false;
				}

				stt = end + 1;
				end = eend;
			}
		}

		return false;
};
