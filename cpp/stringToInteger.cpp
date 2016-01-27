/*
 * Filename: stringToInteger.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 21 Jan 2016 08:55:42 PM EST
 * Description: 
 */

#include <climits>
#include <iostream>

using namespace std;

class Solution
{
	public:
		int myAtoi(string str)
		{
			bool pos = true;
			int i = 0;
			int digit;
			int res = 0;

			while (i < str.length() && str[i] == ' ')
			{
				i++;
			}

			if (i == str.length())
			{
				return 0;
			}
			else if (str[i] == '+')
			{
				i++;
			}
			else if (str[i] == '-')
			{
				i++;
				pos = false;
			}

			while (i < str.length())
			{
				digit = str[i] - '0';
				if (digit < 0 || digit > 9)
				{
					break;
				}

				if (pos && (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > INT_MAX % 10)))
				{
					return INT_MAX;
				}
				else if (!pos && (-res < INT_MIN / 10 || (-res == INT_MIN / 10 && -digit < INT_MIN % 10)))
				{
					return INT_MIN;
				}

				i++;
				res = res * 10 + digit;

				cout << res << endl;
			}

			return pos ? res : -res;
		}
};
