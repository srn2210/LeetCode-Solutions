class Solution {
    int mod = (int)1e9+7;
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int[][][] dp;
    boolean outOfBounds(int i, int j, int m, int n) {
        return i < 0 || j < 0 || i >= m || j >= n;
    }
    int solve(int m, int n, int moves, int i, int j) {
        if(outOfBounds(i, j, m, n)) return 1;
        if(moves == 0) return 0;
        if(dp[i][j][moves] != -1) return dp[i][j][moves];
        long ans = 0;
        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            ans += solve(m, n, moves-1, x, y);
            ans %= mod;
        }
        return dp[i][j][moves] = (int)ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(m, n, maxMove, startRow, startColumn);
    }
}