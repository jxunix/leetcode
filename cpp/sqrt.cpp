/*
 * Filename: sqrt.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Wed 27 Jan 2016 08:50:31 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution {
	public:
		int mySqrt(int x) {
			if (x <= 0)
			{
				return 0;
			}

			int base = 0;
			while (true)
			{
				int i = 1;
				int val = base + i;

				while ((double) val * (double) val <= (double) x)
				{
					if (val * val == x)
					{
						return val;
					}

					i *= 2;
					val = base + i;
				}

				if (i/2 == 0)
				{
					break;
				}

				base += i/2;
			}

			return base;
		}
};
