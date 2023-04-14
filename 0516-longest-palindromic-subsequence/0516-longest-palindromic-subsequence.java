class Solution {
    int solve(String s, int i, int j, int[][] dp) {
        if(j >= s.length() || i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == s.charAt(j)) ans = 2 + solve(s, i-1, j+1, dp);
        else ans = Math.max(solve(s, i-1, j, dp), solve(s, i, j+1, dp));
        return dp[i][j] = ans;
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        int ans = 0;
        for(int i=0; i<s.length(); i++) ans = Math.max(ans, Math.max(solve(s, i-1, i, dp), 1 + solve(s, i-1, i+1, dp)));
        return ans;
    }
}