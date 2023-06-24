class Solution {
    int[][] dp;
    int solve(int[] rods, int idx, int sum) {
        if(idx == rods.length) {
            if(sum == 5000) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int takeLeft = solve(rods, idx+1, sum+rods[idx]) + rods[idx];
        int takeRight = solve(rods, idx+1, sum-rods[idx]) + rods[idx];
        int leave = solve(rods, idx+1, sum);
        int res = Math.max(takeLeft, Math.max(takeRight, leave));
        return dp[idx][sum] = res;
    }
    public int tallestBillboard(int[] rods) {
        dp = new int[20][10001];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(rods, 0, 5000) / 2;
    }
}