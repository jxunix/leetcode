/*
 * Filename: deleteNodeInALinkedList.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Tue 19 Jan 2016 07:56:24 PM EST
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
		void deleteNode(ListNode* node)
		{
			ListNode* prev = new ListNode(0);
			prev->next = node;

			while (node->next)
			{
				node->val = node->next->val;
				node = node->next;
				prev = prev->next;
			}

			prev->next = NULL;
		}
};
