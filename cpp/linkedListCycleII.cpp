/*
 * Filename: linkedListCycleII.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 18 Jan 2016 07:50:37 PM EST
 * Description: 
 */

#include <iostream>

using namespace std;

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
    ListNode *detectCycle(ListNode *head)
		{
			ListNode* p = head;
			ListNode* q = head;

			while (p && p->next)
			{
				p = p->next->next;
				q = q->next;

				if (p == q)
				{
					p = head;

					while (p != q)
					{
						p = p->next;
						q = q->next;
					}

					return p;
				}
			}

			return NULL;
    }
};
