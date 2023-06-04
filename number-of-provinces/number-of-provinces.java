class Solution {
    void dfs(int row, int[][] grid, boolean[] vis) {
        for(int i=0; i<grid.length; i++) {
            if(grid[row][i] == 1 && !vis[i]) {
                vis[i] = true;
                dfs(i, grid, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!vis[i] && isConnected[i][j] == 1) {
                    ans++;
                    vis[i] = true;
                    dfs(i, isConnected, vis);
                }
            }
        }
        return ans;
    }
}