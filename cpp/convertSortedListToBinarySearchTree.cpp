/*
 * Filename: convertSortedListToBinarySearchTree.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 14 Jan 2016 09:30:14 PM EST
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

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution
{
	public:
		TreeNode* sortedListToBST(ListNode* head)
		{
			if (!head)
			{
				return NULL;
			}

			vector<TreeNode*> nodes;
			int size = 0;

			while (head)
			{
				nodes.push_back(new TreeNode(head->val));
				head = head->next;
				size++;
			}

			return sortedListToBSTAux(nodes, 0, size - 1);
		}

	private:
		TreeNode* sortedListToBSTAux(vector<TreeNode*>& nodes, int i, int j)
		{
			if (i == j)
			{
				return nodes[i];
			}
			else if (i+1 == j)
			{
				TreeNode* root = nodes[i];
				root->right = nodes[j];
				return root;
			}
			else
			{
				int mid = (i+j) / 2;
				TreeNode root* = nodes[mid];
				root->left = sortedListToBSTAux(nodes, i, mid - 1);
				root->right = sortedListToBSTAux(nodes, mid + 1, j);
				return root;
			}
		}
};
