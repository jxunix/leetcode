/*
 * Filename: copy_list_with_random_pointer.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 08:11:16 PM EST
 * Description: 
 */

#include <iostream>
#include <map>

using namespace std;

/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */

class Solution {
	public:
		RandomListNode *copyRandomList(RandomListNode *head) {
			if (head == NULL)
			{
				return NULL;
			}

			RandomListNode* res = new RandomListNode(head->label);
			RandomListNode* p = res;

			map<RandomListNode*, RandomListNode*> map;
			map[head] = res;

			while (head != NULL)
			{
				if (head->next != NULL)
				{
					if (map.find(head->next) != map.end())
					{
						p->next = map[head->next];
					}
					else
					{
						p->next = new RandomListNode(head->next->label);
						map[head->next] = p->next;
					}
				}

				if (head->random != NULL)
				{
					if (map.find(head->random) != map.end())
					{
						p->random = map[head->random];
					}
					else
					{
						p->random = new RandomListNode(head->random->label);
						map[head->random] = p->random;
					}
				}

				head = head->next;
				p = p->next;
			}

			return res;
		}
};
