class Solution {
    int[][] dp;
    int solve(String s, int start, int end) {
        if(start > end) return 0;
        if(dp[start][end] != -1 ) return dp[start][end];
        int ans = 1 + solve(s, start, end-1);
        for(int i=start; i<end; i++) {
            if(s.charAt(i) == s.charAt(end)) {
                ans = Math.min(ans, solve(s, start, i) + solve(s, i+1, end-1));
            }
        }
        return dp[start][end] = ans;
    }
    public int strangePrinter(String s) {
        dp = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(s, 0, s.length()-1);
    }
}