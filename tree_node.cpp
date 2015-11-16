/*
 * Filename: tree_node.hpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 07:35:59 PM EST
 * Description: 
 */

#ifndef TREENODE_HPP
#define TREENODE_HPP

struct TreeNode
{
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

#endif
