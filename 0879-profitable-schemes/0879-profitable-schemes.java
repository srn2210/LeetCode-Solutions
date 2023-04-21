class Solution {
    int mod = (int) 1e9+7;
    int solve(int n, int min, int[] group, int[] profit, int idx, int[][][] dp) {
        if(n < 0) return 0;
        if(min < 0) min = 0;
        if(idx == group.length) {
            if(min == 0) return 1;
            return 0;
        }
        
        if(dp[n][idx][min] != -1) return dp[n][idx][min];
        
        int ans = 0;
        ans += solve(n-group[idx], min-profit[idx], group, profit, idx+1, dp) % mod;
        ans += solve(n, min, group, profit, idx+1, dp) % mod;
        return dp[n][idx][min] = ans % mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[n+1][group.length+1][minProfit+1];
        for(int i=0; i<n+1; i++) {
            for(int j=0; j<group.length+1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(n, minProfit, group, profit, 0, dp);
    }
}