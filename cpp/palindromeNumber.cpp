/*
 * Filename: palindromeNumber.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 21 Jan 2016 09:35:40 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		bool isPalindrome(int x)
		{
			if (x < 0)
			{
				return false;
			}

			if (x < 10)
			{
				return true;
			}

			int x2 = x;
			int length = 0;
			int res = 0;
			int digit;

			while (x2)
			{
				x2 /= 10;
				length++;
			}

			for (int i = 0; i < length / 2; i++)
			{
				digit = x % 10;
				x /= 10;
				res = res * 10 + digit;
			}

			if (length % 2)
			{
				return x / 10 == res;
			}
			else
			{
				return x == res;
			}

			return true;
		}
};
