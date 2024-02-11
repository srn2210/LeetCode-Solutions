class Solution {
    int[] directions = {-1, 0, 1};
    public int cherryPickup(int[][] grid) {
        int n = grid[0].length;
        int[][] prev = new int[grid[0].length][grid[0].length];
        for(int i=0; i<n; i++) {
            Arrays.fill(prev[i], -100000);
        }
        prev[0][grid[0].length-1] = grid[0][0] + grid[0][grid[0].length-1];
        int ans = 0;
        for(int i=1; i<grid.length; i++) {
            int[][] dp = new int[grid[0].length][grid[0].length];
            for(int l=0; l<n; l++) {
                Arrays.fill(dp[l], -100000);
            }
            for(int j=0; j<grid[0].length; j++) {
                for(int k=j+1; k<grid[0].length; k++) {
                    for(int j1 : directions) {
                        for(int j2 : directions) {
                            int y1 = j1 + j;
                            int y2 = j2 + k;
                            if(y1 < 0 || y2 < 0 || y1 >= grid[0].length || y2 >= grid[0].length) continue;
                            int val = 0;
                            if(y1 == y2) val = grid[i][y1];
                            else val = grid[i][y1] + grid[i][y2];
                            dp[y1][y2] = Math.max(prev[j][k] + val, dp[y1][y2]);
                            ans = Math.max(ans, dp[y1][y2]);
                        }
                    }
                }
            }
            prev = dp;
        }
        return ans;
    }
}