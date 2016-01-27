/*
 * Filename: reverseInteger.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 21 Jan 2016 08:35:09 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		int reverse(int x)
		{
			int digit;
			int res = 0;

			while (x)
			{
				digit = x % 10;

				if (x > 0 && (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > INT_MAX % 10)) ||
						x < 0 && (res < INT_MIN / 10 || (res == INT_MIN / 10 && digit < INT_MIN % 10)))
				{
					return 0;
				}

				x /= 10;
				res = res * 10 + digit;
			}

			return res;
		}
};
