class Solution {
    void dfs(int row, int[][] grid, boolean[][] vis) {
        if(row < 0 || row >= grid.length) return;
        for(int i=0; i<grid.length; i++) {
            if(grid[row][i] == 1 && !vis[row][i]) {
                vis[row][i] = true;
                dfs(i, grid, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[][] vis = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!vis[i][j] && isConnected[i][j] == 1) {
                    ans++;
                    vis[i][j] = true;
                    dfs(i, isConnected, vis);
                }
            }
        }
        return ans;
    }
}