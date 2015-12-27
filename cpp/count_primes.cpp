/*
 * Filename: count_primes.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 16 Nov 2015 11:26:23 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

class Solution {
	public:
		int countPrimes(int n) {
			if (n <= 2)
			{
				return 0;
			}

			int count = 0;
			bool is_composite[n];
			for (int i = 0; i < n; i++)
			{
				is_composite[i] = false;
			}

			for (int i = 2; i*i < n; i++)
			{
				if (!is_composite[i])
				{
					for (int j = i*i; j < n; j += i)
					{
						is_composite[j] = true;
					}
				}
			}

			for (int i = 2; i < n; i++)
			{
				if (!is_composite[i])
				{
					count++;
				}
			}

			return count;
		}
};
