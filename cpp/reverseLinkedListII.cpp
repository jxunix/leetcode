/*
 * Filename: reverseLinkedListII.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 14 Jan 2016 08:20:50 PM EST
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
		ListNode* reverseBetween(ListNode* head, int m, int n)
		{
			if (m == n)
			{
				return head;
			}

			ListNode* dummy = new ListNode(0);
			dummy->next = head;
			head = dummy;

			ListNode* rHead;
			ListNode* rTail = NULL;
			ListNode* p = rTail;
			ListNode* tmp;
			int count = 0;

			while (head)
			{
				if (count == m-1)
				{
					rHead = head;
					head = head->next;
				}
				else if (count == m)
				{
					tmp = head->next;
					head->next = p;
					p = head;
					rTail = p;
					head = tmp;
				}
				else if (count > m && count < n)
				{
					tmp = head->next;
					head->next = p;
					p = head;
					head = tmp;
				}
				else if (count == n)
				{
					tmp = head->next;
					head->next = p;
					p = head;
					head = tmp;
					rHead->next = p;
					rTail->next = head;
				}
				else
				{
					head = head->next;
				}
				
				count++;
			}

			return dummy->next;
		}
};
