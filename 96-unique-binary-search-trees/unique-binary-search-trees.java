class Solution {
    int[] dp;
    int solve(int n) {
        if(n == 0) return 1;
        if(dp[n] != -1) return dp[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            int left = solve(i);
            int right = solve(n-i-1);
            ans += left * right;
        }
        return dp[n] = ans;
    }
    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    }
}