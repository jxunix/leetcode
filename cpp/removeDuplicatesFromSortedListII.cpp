/*
 * Filename: removeDuplicatesFromSortedListII.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 12 Jan 2016 11:06:07 PM EST
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
		ListNode* deleteDuplicates(ListNode* head)
		{
			if (!head || !head->next)
			{
				return head;
			}

			ListNode* dummy = new ListNode(0);
			dummy->next = head;

			ListNode* curr = head->next;
			ListNode* prev = head;
			ListNode* pprev = dummy;

			for (; curr != NULL; curr = curr->next, prev = prev->next)
			{
				if (curr->val == prev->val)
				{
					pprev->next = curr->next;
				}
				else
				{
					if (pprev->next != prev->next)
					{
						pprev = prev;
					}
				}
			}

			return dummy->next;
		}
};
