class Solution {
    int[][] dp;
    int solve(int[][] pairs, int idx, int prev) {
        if(idx == pairs.length) return 0;
        if(dp[idx][prev+1001] != -1) return dp[idx][prev+1001];
        int ans = solve(pairs, idx+1, prev);
        if(prev < pairs[idx][0]) ans = Math.max(ans, 1 + solve(pairs, idx+1, pairs[idx][1]));
        return dp[idx][prev+1001] = ans;
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        dp = new int[pairs.length][2002];
        for(int i=0; i<pairs.length; i++) Arrays.fill(dp[i], -1);
        return solve(pairs, 0, -1001);
    }
}