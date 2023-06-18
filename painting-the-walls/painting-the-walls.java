class Solution {
    long[][] dp;
    int n;
    long solve(int[] cost, int[] time, int idx, int currTime) {
        if(idx == n) return currTime >= 0 ? 0 : (int)1e9;
        if(dp[idx][currTime + n] != -1) return dp[idx][currTime + n];
        long ans = Math.min(cost[idx] + solve(cost, time, idx+1, Math.min(currTime+time[idx], n)), solve(cost, time, idx+1, currTime-1));
        return dp[idx][currTime + n] = ans;
    }
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        dp = new long[n][2*n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return (int)solve(cost, time, 0, 0);
    }
}