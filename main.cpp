/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <iostream>
#include <map>
#include <string>
#include <vector>

#include "p.hpp"
#include "pr.hpp"
#include "minimum_window_substring.cpp"

using namespace std;

Solution s;
P p;
Pr pr;

int main()
{
	string S = "ADOBECODEBANC";
	string T = "ABC";

	cout << s.minWindow(S, T) << endl;

	return 0;
}
