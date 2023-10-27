class Solution {
    Boolean[][] dp;
    boolean solve(String s, int start, int end) {
        if(start == end) return true;
        if(start > end) return true;
        if(dp[start][end] != null) return dp[start][end];
        boolean ans = false;
        if(s.charAt(start) == s.charAt(end) && solve(s, start+1, end-1)) ans = true;
        solve(s, start+1, end);
        solve(s, start, end-1);
        return dp[start][end] = ans;
    }
    public String longestPalindrome(String s) {
        dp = new Boolean[s.length()][s.length()];
        solve(s, 0, s.length()-1);
        int maxLen = 0, startMax = 0, endMax = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=s.length()-1; j>=i; j--) {
                if(dp[i][j] != null && dp[i][j] && (j-i+1) > maxLen) {
                    maxLen = j-i+1;
                    startMax = i;
                    endMax = j;
                    break;
                }
            }
        }
        return s.substring(startMax, endMax+1);
    }
}