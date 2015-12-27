/*
 * Filename: random_list_node.hpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 08:12:44 PM EST
 * Description: 
 */

#ifndef RANDOM_LIST_NODE_HPP
#define RANDOM_LIST_NODE_HPP

struct RandomListNode
{
	int label;
	RandomListNode *next, *random;
	RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};

#endif
