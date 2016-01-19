/*
 * Filename: insertionSortList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Mon 18 Jan 2016 08:30:13 PM EST
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
		ListNode* insertionSortList(ListNode* head)
		{
			if (!head || !head->next)
			{
				return head;
			}

			ListNode* dummy = new ListNode(0);
			ListNode* prev;
			ListNode* next;

			while (head)
			{
				prev = dummy;
				next = head->next;

				while (prev->next && prev->next->val < head->val)
				{
					prev = prev->next;
				}

				head->next = prev->next;
				prev->next = head;
				head = next;
			}

			return dummy->next;
		}
};
