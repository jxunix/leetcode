/*
 * Filename: construct_binary_tree_from_preorder_and_inorder_traversal.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Tue 04 Aug 2015 07:45:43 PM EDT
 */

#include <iostream>
#include <vector>

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
class Solution {
	public:
		TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder)
		{
			return build_tree_aux(preorder, 0, preorder.size() - 1,
					inorder, 0, inorder.size() - 1);
		}

	private:
		TreeNode* build_tree_aux(
				vector<int>& preorder,
				int pi,
				int pj,
				vector<int>& inorder,
				int ii,
				int ij)
		{
			if (pj < pi)
			{
				return NULL;
			}

			int i = ii;
			for (; i <= ij; i++)
			{
				if (inorder[i] == preorder[pi])
				{
					break;
				}
			}

			TreeNode* root = new TreeNode(preorder[pi]);
			root->left = build_tree_aux(preorder, pi + 1, pi + (i - ii), inorder, ii, i-1);
			root->right = build_tree_aux(preorder, pi + (i - ii) + 1, pj, inorder, i+1, ij);
			return root;
		}
};
