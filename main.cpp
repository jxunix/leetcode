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
#include "removeNthNodeFromEndOfList.cpp"

using namespace std;

P p;
Pr pr;
TreeNode* root;
RandomListNode *rnode;
Solution s;

int main()
{
	ListNode* head = new ListNode(1);
	head->next = new ListNode(2);
	head->next->next = new ListNode(3);
	head->next->next->next = new ListNode(4);
	head->next->next->next->next = new ListNode(5);

	ListNode* p = head;
	cout << "[ ";
	while (p != NULL)
	{
		cout << p->val << " ";
		p = p->next;
	}
	cout << "]" << endl;

	ListNode* res = s.removeNthFromEnd(head, 3);
	p = res;
	cout << "[ ";
	while (p != NULL)
	{
		cout << p->val << " ";
		p = p->next;
	}
	cout << "]" << endl;

	return 0;
}
