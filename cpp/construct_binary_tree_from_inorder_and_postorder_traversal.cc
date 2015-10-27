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
		TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder)
		{
			return build_tree_aux(inorder, 0, inorder.size() - 1,
					postorder, 0, postorder.size() - 1);
		}

	private:
		TreeNode* build_tree_aux(
				vector<int>& inorder,
				int ii,
				int ij,
				vector<int>& postorder,
				int pi,
				int pj)
		{
			if (ij < ii)
			{
				return NULL;
			}

			int i = ii;
			for (; i <= ij; i++)
			{
				if (inorder[i] == postorder[pj])
				{
					break;
				}
			}

			TreeNode* root = new TreeNode(postorder[pj]);
			root->left = build_tree_aux(inorder, ii, i-1,
					postorder, pi, pi + i - ii - 1);
			root->right = build_tree_aux(inorder, i+1, ij,
					postorder, pi + i - ii, pj - 1);
			return root;
		}
};
