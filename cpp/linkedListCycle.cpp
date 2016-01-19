/*
 * Filename: linkedListCycle.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 14 Jan 2016 09:41:14 PM EST
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
		bool hasCycle(ListNode *head)
		{
			ListNode* p = head;
			ListNode* q = head;

			while (p && p->next)
			{
				p = p->next->next;
				q = q->next;

				if (p == q)
				{
					return true;
				}
			}

			return false;
		}
};
