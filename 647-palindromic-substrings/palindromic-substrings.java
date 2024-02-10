class Solution {
    Boolean[][] dp;
    boolean solve(String s, int start, int end) {
        if(start > end) return true;
        if(dp[start][end] != null) return dp[start][end];
        boolean ans = false;
        if(s.charAt(start) == s.charAt(end)) {
            ans = solve(s, start+1, end-1);
        }
        solve(s, start+1, end);
        solve(s, start, end-1);
        return dp[start][end] = ans;
    }
    public int countSubstrings(String s) {
        dp = new Boolean[s.length()][s.length()];
        solve(s, 0, s.length()-1);
        int ans = 0;
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                if(dp[i][j]) ans++;
            }
        }
        return ans;
    }
}