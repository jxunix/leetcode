/*
 * Filename: plusOne.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Wed 27 Jan 2016 08:35:13 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		vector<int> plusOne(vector<int>& digits)
		{
			int carry = 1;

			for (int i = digits.size() - 1; i >= 0; i--)
			{
				carry += digits[i];
				digits[i] = carry % 10;
				carry /= 10;
			}

			if (carry)
			{
				digits.insert(digits.begin(), carry);
			}

			return digits;
		}
};
