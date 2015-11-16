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
			stack.push(root);

			while (!stack.empty())
			{ 
				TreeNode* t = stack.top();
				stack.pop();

				if (t != NULL)
				{
					stack.push(t.left);
					stack.push
					stack.push(t.right);
				}
			}
		}
};
