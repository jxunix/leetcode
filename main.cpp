/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <climits>
#include <iostream>
#include <map>
#include <string>
#include <vector>

#include "p.hpp"
#include "pr.hpp"
#include "point.hpp"
#include "listNode.hpp"
#include "random_list_node.hpp"
#include "tree_node.hpp"
#include "permutationSequence.cpp"

using namespace std;

P p;
Pr pr;
TreeNode* root;
RandomListNode *rnode;
Solution s;

int main()
{
	int n = 3;
	int k = 5;
	cout << s.getPermutation(n, k) << endl;

	return 0;
}
