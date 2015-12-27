/*
 * Filename: point.hpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 15 Nov 2015 09:22:33 PM EST
 * Description: 
 */

#ifndef POINT_HPP
#define POINT_HPP

// Definition for a point
struct Point
{
	int x;
	int y;
	Point() : x(0), y(0) {} 
	Point(int a, int b) : x(a), y(b) {}
};

#endif
