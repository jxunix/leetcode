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
#include "maximal_rectangle.cpp"

using namespace std;

Solution s;
P p;
Pr pr;

int main()
{
	int m = 5;
	int n = 4;
	vector<vector<int> > heights (m, vector<int> (n, 0));
	p.print(heights);

	return 0;
}
