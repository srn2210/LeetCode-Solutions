class Solution {
    int mod = (int)1e9+7;
    long solve(int low, int high, int zero, int one, int curr, long[] dp) {
        if(curr > high) return 0;
        if(dp[curr] != -1) return dp[curr];
        long ans = 0, t = 0;
        if(curr >= low) t = 1;
        ans = t + solve(low, high, zero, one, curr+zero, dp) + solve(low, high, zero, one, curr+one, dp);
        return dp[curr] = (ans)%mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high+1];
        Arrays.fill(dp, -1);
        return (int)(solve(low, high, zero, one, 0, dp) % mod);
    }
}