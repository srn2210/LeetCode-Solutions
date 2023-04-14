class Solution {
    int solve(String s, int i, int j, int[][] dp) {
        if(i == j) return 1;
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == s.charAt(j)) ans = 2 + solve(s, i+1, j-1, dp);
        else ans = Math.max(solve(s, i+1, j, dp), solve(s, i, j-1, dp));
        return dp[i][j] = ans;
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(s, 0, s.length()-1, dp);
    }
}