class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j : coins) {
                if(i-j >= 0 && dp[i-j] != -1) min = Math.min(min, 1+dp[i-j]);
                dp[i] = min == Integer.MAX_VALUE ? dp[i] : min;
            }
        }
        
        return dp[amount];
    }
}