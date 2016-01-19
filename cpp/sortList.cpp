/*
 * Filename: sortList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 18 Jan 2016 10:05:53 PM EST
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
		ListNode* sortList(ListNode* head)
		{
			if (!head || !head->next)
			{
				return head;
			}

			if (!head->next->next)
			{
				if (head->val < head->next->val)
				{
					return head;
				}
				else
				{
					head->next->next = head;
					head = head->next;
					head->next->next = NULL;
					return head;
				}
			}

			ListNode* p = head;
			ListNode* q = head;

			while (p->next && p->next->next)
			{
				p = p->next->next;
				q = q->next;
			}

			ListNode* head2 = q->next;
			q->next = NULL;

			head = sortList(head);
			head2 = sortList(head2);
			return merge(head, head2);
		}

	private:
		ListNode* merge(ListNode* head, ListNode* head2)
		{
			ListNode* res = new ListNode(0);
			ListNode* dummy = res;

			while (head && head2)
			{
				if (head->val < head2->val)
				{
					res->next = head;
					head = head->next;
				}
				else
				{
					res->next = head2;
					head2 = head2->next;
				}

				res = res->next;
			}

			while (head)
			{
				res->next = head;
				head = head->next;
				res = res->next;
			}

			while (head2)
			{
				res->next = head2;
				head2 = head2->next;
				res = res->next;
			}

			return dummy->next;
		}
};
