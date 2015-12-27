/*
 * Filename: fraction_to_recurring_decimal.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 16 Nov 2015 10:05:16 PM EST
 * Description: 
 */

#include <iostream>
#include <map>

using namespace std;

class Solution {
	public:
		string fractionToDecimal(int numerator, int denominator) {
			if (numerator == 0 || denominator == 0)
			{
				return "0";
			}
			
			string res = "";
			if ((numerator < 0) ^ (denominator < 0))
			{
				res += "-";
			}

			long long int num_long = numerator;
			long long int denom_long = denominator;
			num_long = abs(num_long);
			denom_long = abs(denom_long);

			res += to_string(num_long / denom_long);
			int residual = num_long % denom_long;

			if (!residual)
			{
				return res;
			}

			res += ".";
			map<int, int> map;

			while (residual)
			{
				if (map.find(residual) != map.end())
				{
					int i = map[residual];
					//res.insert(i, 1, '(');
					//return res + ")";
					return res.substr(0, i) + "(" + res.substr(i) + ")";
				}

				map[residual] = res.length();
				res += to_string(residual * 10 / denom_long);
				residual = residual * 10 % denom_long;
			}

			return res;
		}
};
