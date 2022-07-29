class Solution {
    int helper(int[] coins, int rem, int[] dp) {
        if(rem < 0) return -1;
        
        if(rem == 0) return 0;
        
        if(dp[rem] != 0) return dp[rem];
        
        int min = Integer.MAX_VALUE;
        
        for(int i:coins) {
            int temp = helper(coins, rem-i, dp);
            if(temp != -1 && temp < min) {
                min = 1 + temp;
            }
        }
        dp[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[rem];
    }
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount+1]);
    }
}