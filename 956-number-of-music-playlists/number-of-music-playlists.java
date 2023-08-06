class Solution {
    int mod = (int)1e9+7;
    long[][] dp;
    long solve(int n, int goal, int k, int total) {
        if(n == 0 && goal == 0) return 1;
        if(n == 0 || goal == 0) return 0;
        if(dp[n][goal] != -1) return dp[n][goal];
        long ans = (solve(n-1, goal-1, k, total) * (total-n+1)) % mod;
        if(n > k) {
            ans += (solve(n, goal-1, k, total) * (n - k)) % mod;
        }
        return dp[n][goal] = ans % mod;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[n+1][goal+1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return (int)solve(n, goal, k, n);
    }
}