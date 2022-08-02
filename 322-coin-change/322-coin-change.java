class Solution {
    /*int helper(int[] coins, int rem, int[] dp) {
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
    }*/
    public int coinChange(int[] coins, int amount) {
        //return helper(coins, amount, new int[amount+1]);
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length && j<=i; j++) {
                if(i-coins[j] >= 0 && dp[i-coins[j]] != -1) min = Math.min(min, 1+dp[i-coins[j]]);
                dp[i] = min == Integer.MAX_VALUE ? dp[i] : min;
            }
        }
        
        return dp[amount];
    }
}