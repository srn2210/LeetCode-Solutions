class Solution {
    int[][][] dp;
    int solve(int[] prices, int idx, int state, int t) {
        if(idx == prices.length) return 0;
        if(dp[idx][state][t] != -1) return dp[idx][state][t];
        int ans = Integer.MIN_VALUE;
        if(state == 0 && t < 2) {
            ans = Math.max(solve(prices, idx+1, 0, t), solve(prices, idx+1, 1, t) - prices[idx]);
        }
        else if(t < 2){
            ans = Math.max(solve(prices, idx+1, 1, t), solve(prices, idx+1, 0, t+1) + prices[idx]);
        }
        else {
            ans = Math.max(ans, solve(prices, idx+1, state, t));
        }
        return dp[idx][state][t] = ans;
    }
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][3];
        for(int[][] d : dp) {
            for(int[] a : d) {
                Arrays.fill(a, -1);
            }
        }
        return solve(prices, 0, 0, 0);
    }
}