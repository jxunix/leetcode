/*
 * Filename: mergeKSortedLists.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 10 Jan 2016 06:29:06 PM EST
 * Description: 
 */

#include <iostream>
#include <queue>
#include <vector>

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
		ListNode* mergeKLists(vector<ListNode*>& lists)
		{
			priority_queue<ListNode*, vector<ListNode*>, compNode> pq;
			ListNode* res = new ListNode(0);
			ListNode* dummy = res;

			for (auto p: lists)
			{
				if (p)
				{
					pq.push(p);
				}
			}

			while (!pq.empty())
			{
				res->next = pq.top();
				res = res->next;
				pq.pop();

				if (res->next)
				{
					pq.push(res->next);
				}
			}

			return dummy->next;
		}

	private:
		struct compNode
		{
			bool operator() (ListNode *p, ListNode *q) const
			{
				return p->val > q->val;
			}  
		};
};
