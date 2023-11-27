class Solution {
    int[][] moves = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, 1}, {2, -1}};
    int mod = (int)1e9+7;
    int[][][] dp;
    boolean safe(int r, int c) {
        return (r >= 0 && c >= 0 && r < 3 && c < 3) || (r == 3 && c == 1);
    }
    int solve(int n, int i, int j) {
        if(n == 0) return 1;
        if(dp[n][i][j] != -1) return dp[n][i][j];
        long ans = 0;
        for(int[] move : moves) {
            int x = move[0];
            int y = move[1];
            int r = x + i;
            int c = y + j;
            if(safe(r, c)) {
                ans += solve(n-1, r, c);
                ans %= mod;
            }
        }
        return dp[n][i][j] = (int)ans%mod;
    }
    public int knightDialer(int n) {
        int r = 4, c = 3;
        int[][] pad = new int[r][c];
        dp = new int[n+1][r][c];
        for(int[][] d : dp) {
            for(int[] p : d) {
                Arrays.fill(p, -1);
            }
        }
        int count = 0;
        for(int i=0; i<r-1; i++) {
            for(int j=0; j<c; j++) {
                pad[i][j] = ++count;
            }
        }
        pad[3][0] = pad[3][2] = -1;
        long ans = 0;
        for(int i=0; i<r-1; i++) {
            for(int j=0; j<c; j++) {
                ans += solve(n-1, i, j);
                ans %= mod;
            }
        }
        ans += solve(n-1, 3, 1);
        return (int)ans % mod;
    }
}