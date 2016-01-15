/*
 * Filename: reverseNodesInKGroup.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 11 Jan 2016 09:56:10 PM EST
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
		ListNode* reverseKGroup(ListNode* head, int k)
		{
			if (k < 2)
			{
				return head;
			}

			ListNode* res = new ListNode(0);
			ListNode* dummy = res;
			ListNode* tail;
			ListNode* tmp;
			ListNode* p;
			ListNode* q;

			while (head)
			{
				p = head;
				q = head;

				for (int i = 0; i < k; i++)
				{
					if (!head)
					{
						res->next = p;
						return dummy->next;
					}

					head = head->next;
				}

				tail = NULL;
				while (p != head)
				{
					tmp = p->next;
					p->next = tail;
					tail = p;
					p = tmp;
				}

				res->next = tail;
				res = q;
			}

			return dummy->next;
		}
};
