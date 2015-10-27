/*
 * Filename: plus_one.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Fri 31 Jul 2015 08:45:12 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		vector<int> plusOne(vector<int>& digits) {
			vector<int> res;

			if (!digits.size()) {
				res.push_back(1);
				return res;
			}

			int sum = 0;
			int digit = 0;
			int carry = 1;

			for (int i = digits.size() - 1; i >= 0; i--) {
				sum = carry + digits[i];
				digit = sum % 10;
				carry = sum / 10;
				res.insert(res.begin(), digit);
			}

			if (carry) {
				res.insert(res.begin(), carry);
			}

			return res;
		}
};
