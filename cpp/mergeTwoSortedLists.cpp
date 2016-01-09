/*
 * Filename: mergeTwoSortedLists.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Fri 08 Jan 2016 11:22:32 PM EST
 * Description: 
 */

#include <iostream>
#include "listNode.cpp"

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
*/

class Solution {
	public:
		ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
			ListNode* res = new ListNode(0);
			ListNode* dummy = res;

			while (l1 != NULL && l2 != NULL)
			{
				if (l1->val < l2->val)
				{
					res->next = new ListNode(l1->val);
					l1 = l1->next;
				}
				else
				{
					res->next = new ListNode(l2->val);
					l2 = l2->next;
				}
				res = res->next;
			}

			while (l1 != NULL)
			{
				res->next = new ListNode(l1->val);
				res = res->next;
				l1 = l1->next;
			}

			while (l2 != NULL)
			{
				res->next = new ListNode(l2->val);
				res = res->next;
				l2 = l2->next;
			}

			return dummy->next;
		}
};
