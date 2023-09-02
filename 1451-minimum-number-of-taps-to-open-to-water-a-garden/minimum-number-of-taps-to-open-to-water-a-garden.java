class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        for(int i=0; i<=n; i++) {
            int left = Math.max(0, i - ranges[i]), right = Math.min(n, i + ranges[i]);
            for(int j=left; j<=right; j++) {
                dp[right] = Math.min(dp[j]+1, dp[right]);
            }
        }
        return dp[n] == (int)1e9 ? -1 : dp[n];
    }
}