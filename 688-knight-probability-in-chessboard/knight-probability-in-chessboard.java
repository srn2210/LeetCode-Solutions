class Solution {
    int[][] directions = new int[][]{{1,2}, {1,-2}, {2,1}, {2,-1}, {-1,2}, {-1,-2}, {-2,1}, {-2,-1}};
    boolean safe(int row, int col, int n) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
    double solve(int n, int k, int row, int col, double[][][] dp) {
        if(k == 0) return 1;
        if(dp[row][col][k] != -1) return dp[row][col][k];
        double ans = 0;
        for(int[] dir : directions) {
            int x = dir[0] + row;
            int y = dir[1] + col;
            if(safe(x, y, n)) {
                ans += solve(n, k-1, x, y, dp);
            }
        }
        return dp[row][col][k] = ans/8.0;
    }
    public double knightProbability(int n, int k, int row, int column) {
        var dp = new double[n][n][k+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(n, k, row, column, dp);
    }
}