class Solution {
    int dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        int ans = 1;
        ans += dfs(grid, i+1, j, vis);
        ans += dfs(grid, i, j+1, vis);
        ans += dfs(grid, i-1, j, vis);
        ans += dfs(grid, i, j-1, vis);
        return ans;
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++) {
            if(!vis[i][0] && grid[i][0] == 1) dfs(grid, i, 0, vis);
            if(!vis[i][n-1] && grid[i][n-1] == 1) dfs(grid, i, n-1, vis);
        }
        for(int i=0; i<n; i++) {
            if(!vis[0][i] && grid[0][i] == 1) dfs(grid, 0, i, vis);
            if(!vis[m-1][i] && grid[m-1][i] == 1) dfs(grid, m-1, i, vis);
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!vis[i][j] && grid[i][j] == 1) ans += dfs(grid, i, j, vis);
            }
        }
        return ans;
    }
}