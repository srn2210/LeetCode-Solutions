class Solution {
    int[][] dp;
    int solve(int[] prices, int idx, int state, int fee) {
        if(idx == prices.length) return 0;
        if(dp[idx][state] != -1) return dp[idx][state];
        int ans = Integer.MIN_VALUE;
        if(state == 0) {
            ans = Math.max(solve(prices, idx+1, 0, fee), solve(prices, idx+1, 1, fee) - prices[idx]);
        }
        else {
            ans = Math.max(solve(prices, idx+1, 1, fee), solve(prices, idx+1, 0, fee) + prices[idx] - fee);
        }
        return dp[idx][state] = ans;
    }
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(prices, 0, 0, fee);
    }
}