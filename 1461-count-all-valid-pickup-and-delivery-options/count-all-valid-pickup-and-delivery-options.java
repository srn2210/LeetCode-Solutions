class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    int solve(int pick, int del, int total) {
        if(pick == total && del == 0) return 1;
        if(dp[pick][del] != -1) return dp[pick][del];
        long ans = 0;
        int remPick = total - pick;
        if(remPick > 0) ans += ((long)remPick * solve(pick+1, del+1, total)) % mod;
        ans %= mod;
        if(del > 0) ans += ((long)del * solve(pick, del-1, total)) % mod;
        ans %= mod;
        return dp[pick][del] = (int)ans;
    }
    public int countOrders(int n) {
        dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return solve(0, 0, n);
    }
}