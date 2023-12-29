class Solution {
    int max = (int)1e8;
    int[][] dp;
    int solve(int[] diff, int d, int idx) {
        if(idx == diff.length && d == 0) {
            return 0;
        }
        if(d < 0 || idx == diff.length) return max;
        if(dp[idx][d] != -1) return dp[idx][d];
        // int currDiff = Math.max(currDiff, diff[idx]);
        int ans = max;
        int currDiff = -1;
        for(int i=idx; i<diff.length; i++) {
            currDiff = Math.max(currDiff, diff[i]);
            ans = Math.min(ans, currDiff + solve(diff, d-1, i+1));
            // System.out.println(ans);
        }
        return dp[idx][d] = ans;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        dp = new int[jobDifficulty.length+1][d+1];
        for(int[] dd : dp) Arrays.fill(dd, -1);
        int ans = solve(jobDifficulty, d, 0);
        return ans == max ? -1 : ans;
    }
}