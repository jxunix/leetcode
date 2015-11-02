/*
 * Filename: pr.hpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:46:30 AM EDT
 */

#ifndef PR_HPP
#define PR_HPP

#include <iostream>
#include <list>
#include <unordered_set>
#include <vector>

class Pr
{
	public:
		template <typename T>
			void print(const std::vector<T>& v)
			{
				print_container(v);
			}

		template <typename T>
			void print(const std::list<T>& l)
			{
				print_container(l);
			}

		template <typename T>
			void print(const T& e)
			{
				std::cout << e;
			}

	private:
		template <typename T>
			void print_container(const T& c)
			{
				std::cout << "[ ";
				bool isFirst = true;
				for (const auto& e : c) {
					if (isFirst)
					{
						isFirst = false;
					}
					else
					{
						std::cout << " ";
					}
					print(e);
				}
				std::cout << " ]";
			}
};

#endif
