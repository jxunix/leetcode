/*
 * Filename: devideTwoIntegers.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 26 Jan 2016 09:19:46 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		int divide(int dividend, int divisor)
		{
			if (dividend == 0)
			{
				return 0;
			}

			if (divisor == 0)
			{
				return INT_MAX;
			}

			if (dividend == INT_MIN && divisor == -1)
			{
				return INT_MAX;
			}

			bool neg = (dividend < 0) ^ (divisor < 0);
			int res = 0;
			long long dend = abs((long long) dividend);
			long long dsor = abs((long long) divisor);

			while (dend >= dsor)
			{
				long long dr = dsor;
				int cnt = 1;

				for (; dr <= dend; dr <<= 1, cnt <<= 1)
				{
					dend -= dr;
					res += cnt;
				}
			}

			return neg ? -res : res;
		}
};
