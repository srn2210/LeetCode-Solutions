class Solution {
    int[][] dp;
    int solve(int amount, int[] coins, int idx) {
        if(amount == 0) return 1;
        if(idx >= coins.length || amount < 0) return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int ans = solve(amount-coins[idx], coins, idx) + solve(amount, coins, idx + 1);
        return dp[idx][amount] = ans;
    }
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int i=0; i<coins.length; i++) Arrays.fill(dp[i], -1);
        return solve(amount, coins, 0);
    }
}