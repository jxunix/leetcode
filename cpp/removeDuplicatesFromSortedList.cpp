/*
 * Filename: removeDuplicatesFromSortedList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 12 Jan 2016 10:49:15 PM EST
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
			ListNode* p = head;

			while (p && p->next)
			{
				if (p->val == p->next->val)
				{
					p->next = p->next->next;
				}
				else
				{
					p = p->next;
				}
			}

			return head;
		}
};
