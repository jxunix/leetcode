/*
 * Filename: listNode.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sat 26 Dec 2015 09:47:47 PM EST
 * Description: 
 */

#ifndef LIST_NODE_H
#define LIST_NODE_H

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

#endif
