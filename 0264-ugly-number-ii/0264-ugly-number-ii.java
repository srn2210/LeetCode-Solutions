class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx1 = 0, idx2 = 0, idx3 = 0;
        for(int i=1; i<n; i++) {
            dp[i] = Math.min(2 * dp[idx1], Math.min(3 * dp[idx2], 5 * dp[idx3]));
            if(dp[i] == 2 * dp[idx1]) idx1++;
            if(dp[i] == 3 * dp[idx2]) idx2++;
            if(dp[i] == 5 * dp[idx3]) idx3++;
        }
        return dp[n-1];
    }
}