class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        int[] prev = new int[amount+1];
        dp[0] = 1;

        for(int i=0; i<coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(i > 0) dp[j] = prev[j];
                if(j - coins[i] >= 0) dp[j] += dp[j-coins[i]];
            }
            for(int k=0; k<dp.length; k++) prev[k] = dp[k];
        }
        return dp[amount];
    }
}