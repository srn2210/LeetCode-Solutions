class Solution {
    int[] directions = {-1, 0, 1};
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                Arrays.fill(dp[i][j], -100000);
            }
        }
        dp[0][0][grid[0].length-1] = grid[0][0] + grid[0][grid[0].length-1];
        int ans = 0;

        for(int i=1; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                for(int k=0; k<grid[0].length; k++) {
                    for(int j1 : directions) {
                        for(int j2 : directions) {
                            int y1 = j1 + j;
                            int y2 = j2 + k;
                            if(y1 < 0 || y2 < 0 || y1 >= grid[0].length || y2 >= grid[0].length) continue;
                            int val = 0;
                            if(y1 == y2) val = grid[i][y1];
                            else val = grid[i][y1] + grid[i][y2];
                            dp[i][y1][y2] = Math.max(dp[i-1][j][k] + val, dp[i][y1][y2]);
                            ans = Math.max(ans, dp[i][y1][y2]);
                        }
                    }
                }
            }
        }
        return ans;
    }
}