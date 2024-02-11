class Solution {
    int[][][] dp;
    int[] directions = {-1, 0, 1};
    int solve(int[][] grid, int i, int j1, int j2) {
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return -100000;
        if(i == grid.length) return 0;
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int ans = 0;
        if(j1 == j2) ans = grid[i][j1];
        else ans = grid[i][j1] + grid[i][j2];
        int res = 0;
        for(int dir : directions) {
            for(int dir2 : directions) {
                int x = i + 1;
                int y1 = j1 + dir;
                int y2 = j2 + dir2;
                res = Math.max(res, ans + solve(grid, x, y1, y2));
            }
        }
        return dp[i][j1][j2] = res;
    }
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(grid, 0, 0, grid[0].length-1);
    }
}