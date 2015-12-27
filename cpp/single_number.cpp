/*
 * Filename: single_number.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 08:07:45 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		int singleNumber(vector<int>& nums)
		{
			int res = 0;

			for (const auto n : nums)
			{
				res ^= n;
			}

			return res;
		}
};
