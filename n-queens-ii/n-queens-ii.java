class Solution {
    boolean check(boolean[][] board, int row, int col) {
        int n = board.length;
        for(int i=0; i<n; i++) {
            if(i == row) continue;
            else {
                if(board[i][col]) return false;
            }
        }
        for(int i=0; i<n; i++) {
            if(i == col) continue;
            else {
                if(board[row][i]) return false;
            }
        }
        int x = row-1, y = col-1;
        while(x < n && y < n && x >= 0 && y >= 0) {
            if(board[x--][y--]) return false;
        }
        x = row-1;
        y = col+1;
        while(x < n && y < n && x >= 0 && y >= 0) {
            if(board[x--][y++]) return false;
        }
        x = row+1;
        y = col-1;
        while(x < n && y < n && x >= 0 && y >= 0) {
            if(board[x++][y--]) return false;
        }
        x = row+1;
        y = col+1;
        while(x < n && y < n && x >= 0 && y >= 0) {
            if(board[x++][y++]) return false;
        }
        return true;
    }
    int backtrack(int row, int col, int n, boolean[][] board) {
        if(col == n) return 1;
        int ans = 0;
        for(int i=0; i<n; i++) {
            board[i][col] = true;
            if(check(board, i, col)) ans += backtrack(row, col+1, n, board);
            board[i][col] = false;
        }
        return ans;
    }
    public int totalNQueens(int n) {
        return backtrack(0, 0, n, new boolean[n][n]);
    }
}