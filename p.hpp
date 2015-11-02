/*
 * Filename: p.hpp
 * Author: Jun Xu
 * Email: junx@cs.bu.edu
 * Created Time: Sun 01 Nov 2015 11:18:40 PM EST
 * Description: 
 */

#ifndef P_HPP
#define P_HPP

#include <iostream>
#include <list>
#include <vector>

class P
{
	public:
		template <typename T>
			void print(const std::vector<T>& v)
			{
				std::cout << "[ ";
				bool is_first = true;
				for (const auto& e : v)
				{
					if (is_first)
					{
						is_first = false;
					}
					else
					{
						std::cout << " ";
					}
					std::cout << e;
				}
				std::cout << " ]" << std::endl;
			}

		template <typename T>
			void print(const std::vector<std::vector<T> >& m)
			{
				std::cout << "[" << std::endl;
				for (const auto& v : m)
				{
					bool is_first = true;
					for (const auto& e : v)
					{
						if (is_first)
						{
							std::cout << "  ";
							is_first = false;
						}
						else
						{
							std::cout << " ";
						}
						std::cout << e;
					}
					std::cout << std::endl;
				}
				std::cout << "]" << std::endl;
			}
};

#endif
