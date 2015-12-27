/*
 * Filename: removeNthNodeFromEndOfList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sat 26 Dec 2015 10:32:30 PM EST
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
		ListNode* removeNthFromEnd(ListNode* head, int n) {
			ListNode* p1 = head;
			ListNode* p2 = head;

			for (int i = 0; i < n; i++)
			{
				p1 = p1->next;
			}

			while (p1 != NULL && p1->next != NULL)
			{
				p1 = p1->next;
				p2 = p2->next;
			}

			p2->next = p2->next->next;
			return head;
		}
};
