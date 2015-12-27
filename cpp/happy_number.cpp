/*
 * Filename: happy_number.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 16 Nov 2015 11:14:23 PM EST
 * Description: 
 */

#include <iostream>
#include <map>

using namespace std;

class Solution {
	public:
		bool isHappy(int n) {
			map<int, int> map;

			while (true)
			{
				if (n == 1)
				{
					return true;
				}
				else if (map.find(n) != map.end())
				{
					return false;
				}
				else
				{
					map[n] = 1;
				}

				int ss = 0;
				while (n)
				{
					int r = n % 10;
					ss += r * r;
					n = n / 10;
				}

				n = ss;
			}
		}
};
