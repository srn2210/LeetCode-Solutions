class Solution {
    int[][] dp;
    int solve(int start, int end, int[] cuts, int left, int right) {
        if(left > right || end - start <= 1) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int ans = Integer.MAX_VALUE;
        for(int i=left; i<=right; i++) {
            ans = Math.min(ans, end - start + solve(start, cuts[i], cuts, left, i-1) + solve(cuts[i], end, cuts, i+1, right));
        }
        return dp[left][right] = ans;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        dp = new int[cuts.length+1][cuts.length+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(0, n, cuts, 0, cuts.length-1);
    }
}