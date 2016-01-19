/*
 * Filename: reorderList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 18 Jan 2016 07:55:35 PM EST
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
	public: void reorderList(ListNode* head)
		{
			if (!head || !head->next)
			{
				return;
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
			head2 = reverse(head2);
			merge(head, head2);
		}

	private:
		ListNode* reverse(ListNode* head)
		{
			ListNode* tail = NULL;
			ListNode* tmp;

			while (head)
			{
				tmp = head->next;
				head->next = tail;
				tail = head;
				head = tmp;
			}

			return tail;
		}

		void merge(ListNode* head, ListNode* head2)
		{
			ListNode* tmp;

			while (head2)
			{
				tmp = head->next;
				head->next = head2;
				head2 = head2->next;
				head = head->next;
				head->next = tmp;
				head = head->next;
			}
		}
};
