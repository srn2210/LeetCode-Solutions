class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    int solve(int n, int k, int target) {
        if(target < 0 || n < 0) return 0;
        if(n == 0 && target == 0) return 1;
        if(dp[n][target] != -1) return dp[n][target];
        long ans = 0;
        for(int i=1; i<=k; i++) {
            ans += solve(n-1, k, target - i);
            ans %= mod;
        }
        return dp[n][target] = (int)ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(n, k, target);
    }
}