/*
 * Filename: addTwoNumbers.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sat 26 Dec 2015 09:46:55 PM EST
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

class Solution {
	public:
		ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
		{
			ListNode* res = new ListNode(0);
			ListNode* p = res;
			int sum = 0;
			int carry = 0;

			while (l1 != NULL && l2 != NULL)
			{
				sum = l1->val + l2->val + carry;
				carry = sum / 10;
				p->next = new ListNode(sum % 10);
				p = p->next;
				l1 = l1->next;
				l2 = l2->next;
			}

			while (l1 != NULL)
			{
				sum = l1->val + carry;
				carry = sum / 10;
				p->next = new ListNode(sum % 10);
				p = p->next;
				l1 = l1->next;
			}

			while (l2 != NULL)
			{
				sum = l2->val + carry;
				carry = sum / 10;
				p->next = new ListNode(sum % 10);
				p = p->next;
				l2 = l2->next;
			}

			if (carry)
			{
				p->next = new ListNode(carry);
			}

			return res->next;
		}
};
