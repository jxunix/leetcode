/*
 * Filename: binary_tree_inorder_traversal.cpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Thu 12 Nov 2015 11:23:19 PM EST
 * Description: 
 */

#include <iostream>
#include <stack>

using namespace std;

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
		vector<int> inorderTraversal(TreeNode* root)
		{
			vector<int> res;
			stack<TreeNode*> stack;

			while (!stack.empty() || root != NULL)
			{ 
				if (root != NULL)
				{
					stack.push(root);
					root = root->left;
				}
				else
				{
					root = stack.top();
					stack.pop();
					res.push_back(root->val);
					root = root->right;
				}
			}

			return res;
		}
};
