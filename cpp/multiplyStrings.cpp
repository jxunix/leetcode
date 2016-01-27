/*
 * Filename: multiplyStrings.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 26 Jan 2016 09:33:15 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution
{
	public:
		string multiply(string num1, string num2)
		{
			num1.erase(0, min(num1.find_first_not_of('0'), num1.size() - 1));
			num2.erase(0, min(num2.find_first_not_of('0'), num2.size() - 1));

			if (num1 == "0" || num2 == "0")
			{
				return "0";
			}

			if (num1 == "1")
			{
				return num2;
			}

			if (num2 == "1")
			{
				return num1;
			}

			string res = "";
			for (int i = 0; i < num1.length(); i++)
			{
				string prod = multiplyAux(num1[i] - '0', num2);
				cout << "product: " << prod << endl;

				for (int j = 0; j < num1.length() - i - 1; j++)
				{
					prod += "0";
				}

				res = add(res, prod);
				cout << "sum: " << res << endl;
			}

			return res;
		}

	private:
		string multiplyAux(int num1, string num2)
		{
			if (num1 == 0)
			{
				return "0";
			}

			int i = num2.length() - 1;
			int carry = 0;
			string res = "";

			while (i >= 0)
			{
				carry += num1 * (num2[i] - '0');
				res = to_string(carry % 10) + res;
				carry /= 10;
				i--;
			}

			if (carry)
			{
				res = to_string(carry) + res;
			}

			return res;
		}

		string add(string num1, string num2)
		{
			if (num1 == "0")
			{
				return num2;
			}

			if (num2 == "0")
			{
				return num1;
			}

			int i = num1.length() - 1;
			int j = num2.length() - 1;
			int carry = 0;
			string res = "";

			while (i >= 0 && j >= 0)
			{
				carry += (num1[i] - '0') + (num2[j] - '0');
				res = to_string(carry % 10) + res;
				carry /= 10;
				i--;
				j--;
			}

			while (i >= 0)
			{
				carry += (num1[i] - '0');
				res = to_string(carry % 10) + res;
				carry /= 10;
				i--;
			}

			while (j >= 0)
			{
				carry += (num2[j] - '0');
				res = to_string(carry % 10) + res;
				carry /= 10;
				j--;
			}

			if (carry)
			{
				res = to_string(carry) + res;
			}

			return res;
		}
};
