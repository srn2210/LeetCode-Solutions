class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int j:coins) {
                if(j <= i && dp[i-j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i-j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}