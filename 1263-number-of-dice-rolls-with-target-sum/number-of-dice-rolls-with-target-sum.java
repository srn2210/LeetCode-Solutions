class Solution {
    int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=k; j++) {
                for(int l=j; l<=target; l++) {
                    dp[i][l] += dp[i-1][l-j];
                    dp[i][l] %= mod;
                }
            }
        }

        return dp[n][target];
    }
}