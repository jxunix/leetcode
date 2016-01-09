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
#include "mergeTwoSortedLists.cpp"

using namespace std;

P p;
Pr pr;
TreeNode* root;
RandomListNode *rnode;
Solution s;

int main()
{
	ListNode* head1 = new ListNode(1);
	head1->next = new ListNode(3);
	head1->next->next = new ListNode(5);
	ListNode* head2 = new ListNode(2);
	head2->next = new ListNode(4);
	head2->next->next = new ListNode(6);

	cout << "head1: ";
	ListNode* p = head1;
	cout << "[ ";
	while (p != NULL)
	{
		cout << p->val << " ";
		p = p->next;
	}
	cout << "]" << endl;

	cout << "head2: ";
	p = head2;
	cout << "[ ";
	while (p != NULL)
	{
		cout << p->val << " ";
		p = p->next;
	}
	cout << "]" << endl;
	ListNode* res = s.mergeTwoLists(head1, head2);

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
