class Solution {
    int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    boolean dfs(char[][] board, String word, int i, int j, int s, boolean[][] vis) {
        if(s == word.length()-1) return true;
        vis[i][j] = true;
        for(int[] dir:directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || vis[x][y] || (s+1 < word.length() && board[x][y] != word.charAt(s+1))) continue;
            else {
                if(dfs(board, word, x, y, s+1, vis)) return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, i, j, 0, vis)) return true;
                }
            }
        }
        return false;
    }
}