class Solution {
public:
    int subno(int row, int col) {
        return (3 * (row/3)) + (col / 3);
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<unordered_set<char>> rows(9);
        vector<unordered_set<char>> cols(9);
        vector<unordered_set<char>> subs(9);
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    int k = subno(i,j);
                    if(rows[i].find(board[i][j]) != rows[i].end()) return false;
                    if(cols[j].find(board[i][j]) != cols[j].end()) return false;
                    if(subs[k].find(board[i][j]) != subs[k].end()) return false;
                    rows[i].insert(board[i][j]);
                    cols[j].insert(board[i][j]);
                    subs[k].insert(board[i][j]);
                }
            }
        }
        return true;
    }
};