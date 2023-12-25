class Solution {
    int[] dp;
    int solve(String s, int idx) {
        if(idx > s.length()) return 0;
        if(idx == s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = solve(s, idx+1);
        if(idx + 2 <= s.length() && Integer.parseInt(s.substring(idx, idx+2)) <= 26) ans += solve(s, idx+2);
        return dp[idx] = ans;
    }
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return solve(s, 0);
    }
}