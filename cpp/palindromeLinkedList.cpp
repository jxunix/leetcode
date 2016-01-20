/*
 * Filename: palindromeLinkedList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 19 Jan 2016 07:35:41 PM EST
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
		bool isPalindrome(ListNode* head)
		{
			if (!head || !head->next)
			{
				return true;
			}

			if (!head->next->next)
			{
				return head->val == head->next->val;
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
			head = reverse(head);

			if (p->next)
			{
				return isEqual(head, head2);
			}
			else
			{
				return isEqual(head->next, head2);
			}
		}

	private:
		ListNode* reverse(ListNode* head)
		{
			ListNode* tail = NULL;
			ListNode* next; 
			while (head)
			{
				next = head->next;
				head->next = tail;
				tail = head;
				head = next;
			}

			return tail;
		}

		bool isEqual(ListNode* p, ListNode* q)
		{
			while (p && q)
			{
				if (p->val != q->val)
				{
					return false;
				}

				p = p->next;
				q = q->next;
			}

			return p == q;
		}
};
