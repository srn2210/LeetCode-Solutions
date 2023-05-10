class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length+1;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<n; i++) {
            int temp = i < n-1 ? cost[i] : 0;
            dp[i] = Math.min(dp[i-1], dp[i-2]) + temp;
        }
        return dp[n-1];
    }
}