/*
 * Filename: rotateList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 12 Jan 2016 10:37:17 PM EST
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
		ListNode* rotateRight(ListNode* head, int k)
		{
			if (!head || !k)
			{
				return head;
			}

			ListNode* p = head;
			ListNode* q = head;
			ListNode* res;

			int size = 0;
			while (p)
			{
				size++;
				p = p->next;
			}

			k %= size;
			if (!k)
			{
				return head;
			}

			p = head;
			for (int i = 0; i < k; i++)
			{
				p = p->next;
			}

			while (p->next)
			{
				p = p->next;
				q = q->next;
			}

			res = q->next;
			q->next = NULL;
			p->next = head;

			return res;
		}
};
