class Solution {
    boolean isValid(int row, int col, char n, char[][] board) {
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == n) return false; 
        }
        for(int i=0; i<board[row].length; i++) {
            if(board[row][i] == n) return false;
        }
        
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        
        for(int i=x; i<x+3; i++) {
            for(int j=y; j<y+3; j++) {
                if(i == row || j == col) continue;
                
                if(board[i][j] == n) return false;
            }
        }
        
        return true;
    }
    boolean solve(char[][] board) {
        char[] ch = new char[]{'1','2','3','4','5','6','7','8','9'};
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == '.') {
                    for(char c : ch) {
                        if(isValid(i, j, c, board)) {
                            board[i][j] = c;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}