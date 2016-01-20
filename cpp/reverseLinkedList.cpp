/*
 * Filename: reverseLinkedList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 19 Jan 2016 07:30:12 PM EST
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
		ListNode* reverseList(ListNode* head)
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
};
