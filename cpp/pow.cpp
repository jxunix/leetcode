/*
 * Filename: pow.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 26 Jan 2016 10:13:15 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution {
	public:
		double myPow(double x, int n) {
			if (n == 0)
			{
				return 1;
			}

			double val = myPow(x, n / 2);
			if (n < 0)
			{
				x = 1 / x;
				n = -n;
			}

			if (n % 2)
			{
				return val * val * x;
			}
			else
			{
				return val * val;
			}
		}
};
