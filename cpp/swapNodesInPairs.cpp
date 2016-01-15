/*
 * Filename: swapNodesInPairs.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 11 Jan 2016 09:44:04 PM EST
 * Description: 
 */

#include <iostream>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution
{
	public:
		ListNode* swapPairs(ListNode* head)
		{
			ListNode* res = new ListNode(0);
			ListNode* dummy = res;
			ListNode* p;
			ListNode* q;

			while (head && head->next)
			{
				p = head;
				q = head->next;
				head = head->next->next;

				res->next = q;
				q->next = p;
				p->next = NULL;
				res = res->next->next;
			}

			if (head)
			{
				res->next = head;
			}

			return dummy->next;
		}
};
