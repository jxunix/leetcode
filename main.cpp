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
#include "point.hpp"
#include "listNode.cpp"
#include "random_list_node.hpp"
#include "tree_node.hpp"
#include "addTwoNumbers.cpp"

using namespace std;

P p;
Pr pr;
TreeNode* root;
RandomListNode *rnode;
Solution s;

int main()
{
	ListNode* l1 = new ListNode(2);
	l1->next = new ListNode(4);
	l1->next->next = new ListNode(3);

	ListNode* l2 = new ListNode(5);
	l2->next = new ListNode(6);
	l2->next->next = new ListNode(4);

	ListNode* res = s.addTwoNumbers(l1, l2);

	cout << "[ ";
	while (res)
	{
		cout << res->val << " ";
		res = res->next;
	}
	cout << "]";

	return 0;
}
