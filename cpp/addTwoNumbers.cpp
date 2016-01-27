/*
 * Filename: addTwoNumbers.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 21 Jan 2016 08:30:12 PM EST
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
		ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
		{
			ListNode* res = new ListNode(0);
			ListNode* p = res;
			int carry = 0;
			
			while (l1 && l2)
			{
				carry += l1->val + l2->val;
				p->next = new ListNode(carry % 10);
				carry /= 10;
				l1 = l1->next;
				l2 = l2->next;
				p = p->next;
			}

			while (l1)
			{
				carry += l1->val;
				p->next = new ListNode(carry % 10);
				carry /= 10;
				l1 = l1->next;
				p = p->next;
			}

			while (l2)
			{
				carry += l2->val;
				p->next = new ListNode(carry % 10);
				carry /= 10;
				l2 = l2->next;
				p = p->next;
			}

			if (carry)
			{
				p->next = new ListNode(carry);
			}

			return res->next;
		}
};
