class Solution {
    long solve(int[][] que, int idx, long[] dp) {
        if(idx >= que.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        long ans = 0;
        ans = Math.max(solve(que, idx+1, dp), que[idx][0] + solve(que, idx+que[idx][1]+1, dp));
        return dp[idx] = ans;
    }
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return solve(questions, 0, dp);
    }
}