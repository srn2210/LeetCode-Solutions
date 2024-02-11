class Solution {
    int[][][] dp;
    int[][] directions = {{1, -1}, {1, 0}, {1, 1}};
    int solve(int[][] grid, int i1, int j1, int i2, int j2) {
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return -100000;
        if(i1 == grid.length) return 0;
        if(dp[i1][j1][j2] != -1) return dp[i1][j1][j2];
        int ans = 0;
        if(i1 == i2 && j1 == j2) ans = grid[i1][j1];
        else {
            ans += grid[i1][j1];
            ans += grid[i2][j2];
        }
        int res = 0;
        for(int[] dir : directions) {
            for(int[] dir2 : directions) {
                int x1 = i1 + dir[0];
                int y1 = j1 + dir[1];
                int x2 = i2 + dir2[0];
                int y2 = j2 + dir2[1];                
                res = Math.max(res, ans + solve(grid, x1, y1, x2, y2));
            }
        }
        
        return dp[i1][j1][j2] = res;
    }
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(grid, 0, 0, 0, grid[0].length-1);
    }
}