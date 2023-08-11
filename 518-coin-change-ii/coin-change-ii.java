class Solution {
    int[][] dp;
    int solve(int amount, int[] coins, int idx) {
        if(amount == 0) return 1;
        if(idx >= coins.length || amount < 0) return 0;
        if(dp[amount][idx] != -1) return dp[amount][idx];
        int ans = 0;
        for(int i=idx; i<coins.length; i++) {
            ans += solve(amount-coins[i], coins, i);
        }
        return dp[amount][idx] = ans;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dp = new int[amount+1][coins.length];
        for(int i=0; i<=amount; i++) Arrays.fill(dp[i], -1);
        return solve(amount, coins, 0);
    }
}