/*
 * Filename: partitionList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 14 Jan 2016 08:13:07 PM EST
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
		ListNode* partition(ListNode* head, int x)
		{
			ListNode* less = new ListNode(0);
			ListNode* more = new ListNode(0);
			ListNode* p = less;
			ListNode* q = more;

			while (head)
			{
				if (head->val < x)
				{
					p->next = head;
					p = p->next;
				}
				else
				{
					q->next = head;
					q = q->next;
				}

				head = head->next;
			}

			p->next = more->next;
			q->next = NULL;
			return less->next;
		}
};
