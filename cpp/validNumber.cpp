/*
 * Filename: validNumber.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Wed 27 Jan 2016 09:11:26 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		bool isNumber(string s)
		{
			enum InputType {
				INVALID,
				SPACE,
				SIGN,
				DIGIT,
				DOT,
				EXPONENT,
			};

			int transTable[][6] = {
				-1,  0,  3,  1,  2, -1,
				-1,  8, -1,  1,  4,  5,
				-1, -1, -1,  4, -1, -1,
				-1, -1, -1,  1,  2, -1,
				-1,  8, -1,  4, -1,  5,
				-1, -1,  6,  7, -1, -1,
				-1, -1, -1,  7, -1, -1,
				-1,  8, -1,  7, -1, -1,
				-1,  8, -1, -1, -1, -1,
			};

			int state = 0;
			int i = 0;

			while (i < s.length())
			{
				InputType input = INVALID;
				char c = s[i];

				if (c == ' ')
				{
					input = SPACE;
				}
				else if (c == '+' || c == '-')
				{
					input = SIGN;
				}
				else if (isdigit(c))
				{
					input = DIGIT;
				}
				else if (c == '.')
				{
					input = DOT;
				}
				else if (c == 'e' || c == 'E')
				{
					input = EXPONENT;
				}

				state = transTable[state][input];
				if (state == -1)
				{
					return false;
				}

				i++;
			}

			return state == 1 || state == 4 || state == 7 || state == 8;
		}
};
