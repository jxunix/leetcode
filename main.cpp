/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <algorithm>
#include <cctype>
#include <iostream>
#include <locale>
#include <map>
#include <string>
#include <vector>

#include "p.hpp"
#include "pr.hpp"
#include "point.hpp"
#include "listNode.hpp"
#include "random_list_node.hpp"
#include "tree_node.hpp"
#include "validNumber.cpp"

using namespace std;

P p;
Pr pr;
TreeNode* root;
RandomListNode *rnode;
Solution s;

int main()
{
	string str = "123456|123";

	//char* cstr = new char[str.length() - 1];
	//strcpy(cstr, str.c_str());

	//char* before = strtok(cstr, ".");
	//char* after = strtok(NULL, ".");
	//cout << before << "|" << after << endl;
	//delete [] cstr;

	cout << s.isDecimal(str) << endl;

	return 0;
}
