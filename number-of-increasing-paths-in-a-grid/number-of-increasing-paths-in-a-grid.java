class Solution {
    int m, n, mod = (int)1e9+7;
    int[][] dp;
    int solve(int[][] grid, int r, int c, int prev) {
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] <= prev) {
            return 0;
        }
        if(dp[r][c] != -1) return dp[r][c];
        int down = solve(grid, r+1, c, grid[r][c]);
        int right = solve(grid, r, c+1, grid[r][c]);
        int up = solve(grid, r-1, c, grid[r][c]);
        int left = solve(grid, r, c-1, grid[r][c]);
        long sum = ((long)up + down + left + right) % mod;
        return dp[r][c] = (int)((sum + 1) % mod);
    }
    public int countPaths(int[][] grid) {
        m = grid.length; n = grid[0].length;
        dp = new int[m][n];
        for(int[] d : dp) Arrays.fill(d, -1);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] == -1) {
                    solve(grid, i, j, -1);
                }
            }
        }
        long sum = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sum = sum + dp[i][j];
                sum %= mod;
            }
        }
        return (int) (sum % mod);
    }
}