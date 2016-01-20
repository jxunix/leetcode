/*
 * Filename: intersectionOfTwoLinkedLists.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 19 Jan 2016 06:38:40 PM EST
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
		ListNode *getIntersectionNode(ListNode *headA, ListNode *headB)
		{
			ListNode* p = headA;
			ListNode* q = headB;
			ListNode* r;

			while (p && q)
			{
				p = p->next;
				q = q->next;
			}

			if (p)
			{
				r = headA;
				while (p)
				{
					p = p->next;
					r = r->next;
				}

				q = headB;
				while (q && r)
				{
					if (q == r)
					{
						return q;
					}

					q = q->next;
					r = r->next;
				}
			}
			else
			{
				r = headB;
				while (q)
				{
					q = q->next;
					r = r->next;
				}

				p = headA;
				while (p && r)
				{
					if (p == r)
					{
						return p;
					}

					p = p->next;
					r = r->next;
				}
			}

			return NULL;
		}
};
