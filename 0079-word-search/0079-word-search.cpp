class Solution {
public:
    bool dfs(vector<vector<char>>& board, string word, int idx, int row, int col) {
        if(idx == word.size()) return true;
        if(row >= board.size() || row < 0 || col < 0 || col >= board[0].size() || word[idx] != board[row][col]) return false;
        board[row][col] = '.';
        if(dfs(board, word, idx + 1, row+1, col)) return true;
        if(dfs(board, word, idx + 1, row, col+1)) return true;
        if(dfs(board, word, idx + 1, row-1, col)) return true;
        if(dfs(board, word, idx + 1, row, col-1)) return true;
        board[row][col] = word[idx];
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        for(int i=0; i<board.size(); i++) {
            for(int j=0; j<board[0].size(); j++) {
                if(word[0] == board[i][j]) {
                    if(dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
};