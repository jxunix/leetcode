/*
 * Filename: addBinary.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Wed 27 Jan 2016 08:45:55 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		string addBinary(string a, string b)
		{
			int carry = 0;
			int i = a.length() - 1;
			int j = b.length() - 1;
			string res = "";

			while (i >= 0 && j >= 0)
			{
				carry += (a[i] - '0') + (b[j] - '0');
				res = to_string(carry % 2) + res;
				carry /= 2;
				i--;
				j--;
			}

			while (i >= 0)
			{
				carry += a[i] - '0';
				res = to_string(carry % 2) + res;
				carry /= 2;
				i--;
			}

			while (j >= 0)
			{
				carry += b[j] - '0';
				res = to_string(carry % 2) + res;
				carry /= 2;
				j--;
			}

			if (carry)
			{
				res = to_string(carry) + res;
			}

			return res;
		}
};
