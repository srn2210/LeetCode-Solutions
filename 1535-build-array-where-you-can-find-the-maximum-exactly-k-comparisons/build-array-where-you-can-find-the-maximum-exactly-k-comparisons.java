class Solution {
    int mod = (int)1e9+7;
    int[][][] dp;
    int solve(int n, int m, int k, int max) {
        if(n == 0 && k == 0) return 1;
        if(n == 0) return 0;
        if(dp[n][k][max] != -1) return dp[n][k][max];
        long ans = 0;
        ans += ((long)max * solve(n-1, m, k, max)) % mod;
        ans %= mod;
        ans %= mod;
        if(k > 0) {
            for(int i=max+1; i<=m; i++) {
                ans += solve(n-1, m, k-1, i);
                ans %= mod;
            }
        }
        return dp[n][k][max] = (int)(ans % mod);
    }
    public int numOfArrays(int n, int m, int k) {
        if(m < k) return 0;
        dp = new int[n+1][k+1][101];
        for(int i=0; i<dp.length; i++) for(int j=0; j<dp[i].length; j++) Arrays.fill(dp[i][j], -1);
        return solve(n, m, k, 0);
    }
}