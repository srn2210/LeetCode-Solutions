class Solution {
    int[][] dp;
    int mod = (int)1e9+7;
    int solve(int n, int k) {
        if(n == 0) {
            if(k == 0) return 1;
            return 0;
        }
        if(dp[n][k] != -1) return dp[n][k];
        long ans = 0;
        ans += solve(n-1, k);
        if(k >= 1) {
            ans += solve(n, k-1);
            ans %= mod;
            if(k >= n + 1) {
                ans = (ans - solve(n-1, k - n - 1) + mod) % mod;
            }
        }
        
        ans %= mod;
        return dp[n][k] = (int)ans;
    }
    public int kInversePairs(int n, int k) {
        dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(n-1, k);
    }
}