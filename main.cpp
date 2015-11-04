/*
 * Filename: main.cpp
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Thu 23 Jul 2015 11:09:51 AM EDT
 */

#include <iostream>
#include <map>
#include <string>
#include <vector>

#include "p.hpp"
#include "pr.hpp"
#include "sudoku_solver.cpp"

using namespace std;

Solution s;
P p;
Pr pr;

int main()
{
	string board_array[] = {
		"53..7....",
		"6..195...",
		".98....6.",
		"8...6...3",
		"4..8.3..1",
		"7...2...6",
		".6....28.",
		"...419..5",
		"....8..79"};
	vector<vector<char> > board;

	for (auto i : board_array)
	{
		vector<char> row (i.begin(), i.end());
		board.push_back(row);
	}

	cout << "before:" << endl;
	p.print(board);
	s.solveSudoku(board);

	cout << "after:" << endl;
	p.print(board);

	return 0;
}
