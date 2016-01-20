/*
 * Filename: removeLinkedListElements.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 19 Jan 2016 07:25:54 PM EST
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
		ListNode* removeElements(ListNode* head, int val)
		{
			ListNode* res = new ListNode(0);
			res->next = head;
			head = res;

			while (head->next)
			{
				if (head->next->val == val)
				{
					head->next = head->next->next;
				}
				else
				{
					head = head->next;
				}
			}

			return res->next;
		}
};
