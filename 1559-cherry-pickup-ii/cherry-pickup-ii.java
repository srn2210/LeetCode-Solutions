class Solution {
    int[][][][] dp;
    int[][] directions = {{1, -1}, {1, 0}, {1, 1}};
    boolean isValid(int x1, int y1, int x2, int y2, int[][] grid) {
        return x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 && x1 < grid.length && x2 < grid.length && y1 < grid[0].length && y2 < grid[0].length;
    }
    int solve(int[][] grid, int i1, int j1, int i2, int j2) {
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return -100000;
        if(i1 == grid.length) return 0;
        if(dp[i1][j1][i2][j2] != -1) return dp[i1][j1][i2][j2];
        int ans = 0;
        
        for(int[] dir : directions) {
            for(int[] dir2 : directions) {
                int x1 = i1 + dir[0];
                int y1 = j1 + dir[1];
                int x2 = i2 + dir2[0];
                int y2 = j2 + dir2[1];
                int val1 = 0, val2 = 0;
                if(!isValid(x1, y1, x2, y2, grid)) continue;
                if(x1 == x2 && y1 == y2) val1 = grid[x1][y1];
                else {
                    val1 = grid[x1][y1];
                    val2 = grid[x2][y2];
                }
                // System.out.println(x1 + "," + y1 + ", value - " + val1 + " --- " + x2 + "," + y2 + ", value - " + val2);
                
                ans = Math.max(ans, val1 + val2 + solve(grid, x1, y1, x2, y2));
                // grid[x1][y1] = val1;
                // grid[x2][y2] = val2;
            }
        }
        
        return dp[i1][j1][i2][j2] = ans;
    }
    public int cherryPickup(int[][] grid) {
        dp = new int[grid.length][grid[0].length][grid.length][grid[0].length];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                for(int k=0; k<dp[i][j].length; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return grid[0][0] + grid[0][grid[0].length-1] + solve(grid, 0, 0, 0, grid[0].length-1);
    }
}