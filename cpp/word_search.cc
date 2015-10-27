/*
 * Filename: word_search.cc
 * Author: Jun Xu
 * Email: jxu.vimacs@gmail.com
 * Created Time: Sun 02 Aug 2015 07:53:42 PM EDT
 */

#include <iostream>
#include <vector>

using namespace std;

class Solution {
	public:
		bool exist(vector<vector<char> >& board, string word)
		{
			if (!word.compare(""))
			{
				return true;
			}

			if (!board.size() || !board[0].size())
			{
				return false;
			}

			int m = board.size();
			int n = board[0].size();
			vector<vector<bool> > visited;

			for (int i = 0; i < m; i++)
			{
				vector<bool> v;

				for (int j = 0; j < n; j++)
				{
					v.push_back(false);
				}

				visited.push_back(v);
			}

			for (int i = 0; i < m; i++)
			{
				for (int j = 0; j < n; j++)
				{
					if (exist_aux(board, i, j, word, 0, visited))
					{
						return true;
					}
				}
			}

			return false;
		}

	private:
		bool exist_aux(
				vector<vector<char> >& board,
				int i,
				int j,
				string word,
				int k,
				vector<vector<bool> >& visited)
		{
			if (k == word.length())
			{
				return true;
			}

			if (i < 0 || i >= board.size())
			{
				return false;
			}

			if (j < 0 || j >= board[i].size())
			{
				return false;
			}

			if (visited[i][j] || word[k] - board[i][j])
			{
				return false;
			}

			visited[i][j] = true;
			bool res = exist_aux(board, i-1, j, word, k+1, visited)
				|| exist_aux(board, i+1, j, word, k+1, visited)
				|| exist_aux(board, i, j-1, word, k+1, visited)
				|| exist_aux(board, i, j+1, word, k+1, visited);
			visited[i][j] = false;
			return res;
		}
};
