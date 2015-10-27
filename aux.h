/*
 * Filename: aux.h
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:46:30 AM EDT
 */

#ifndef AUX_H
#define AUX_H

#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Aux
{
	public:
		void print1d(vector<int>& nums)
		{
			cout << "[ ";

			for (vector<int>::size_type i = 0; i < nums.size(); i++)
			{
				cout << nums[i] << " ";
			}

			cout << "]" << endl;
		}

		void print1d(vector<string>& nums)
		{
			cout << "[ ";

			for (vector<string>::size_type i = 0; i < nums.size(); i++)
			{
				cout << nums[i] << " ";
			}

			cout << "]" << endl;
		}

		void print1d(unordered_set<string>& nums)
		{
			cout << "[ ";

			for (auto i = nums.begin(); i != nums.end(); i++)
			{
				cout << *i << " ";
			}

			cout << "]" << endl;
		}

		void print2d(const vector<vector<int> >& nums) {
			cout << "[" << endl;

			for (vector<vector<int> >::size_type i = 0; i < nums.size(); i++) {
				for (vector<int>::size_type j = 0; j < nums[i].size(); j++) {
					cout << " " << nums[i][j];
				}

				cout << endl;
			}

			cout << "]" << endl;
		}

		void print2d(const vector<vector<char> >& nums) {
			cout << "[" << endl;

			for (vector<vector<char> >::size_type i = 0; i < nums.size(); i++) {
				for (vector<char>::size_type j = 0; j < nums[i].size(); j++) {
					cout << " " << nums[i][j];
				}

				cout << endl;
			}

			cout << "]" << endl;
		}

		void print2d(const vector<vector<string> >& nums) {
			cout << "[" << endl;

			for (vector<vector<string> >::size_type i = 0; i < nums.size(); i++) {
				for (vector<string>::size_type j = 0; j < nums[i].size(); j++) {
					cout << " " << nums[i][j];
				}

				cout << endl;
			}

			cout << "]" << endl;
		}
};

#endif
