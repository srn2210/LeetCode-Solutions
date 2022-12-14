class Solution {
    String ans;
    boolean solve(String s, Boolean[][] dp, int i, int j) {
        if(i > j) return false;
        if(i == j) return true;
        if(i+1 == j && s.charAt(i) == s.charAt(j)) {
            if(j-i+1 > ans.length()) ans = s.substring(i, j+1);
            return dp[i][j] = true;
        }
        if(dp[i][j] != null) return dp[i][j];
        dp[i][j] = solve(s, dp, i+1, j-1) && s.charAt(i) == s.charAt(j);
        dp[i][j-1] = solve(s, dp, i, j-1);
        dp[i+1][j] = solve(s, dp, i+1, j);
        if(dp[i][j] && j-i+1 > ans.length()) ans = s.substring(i, j+1);
        return dp[i][j];
    }
    public String longestPalindrome(String s) {
        ans = String.valueOf(s.charAt(0));
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        solve(s, dp, 0, s.length()-1);
        return ans;
    }
}