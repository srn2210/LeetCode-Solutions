class Solution {
    int solve(String s, int left, int right, int[][] dp) {
        if(left > right) return 0;
        if(dp[left][right] != -1) return dp[left][right];
        int ans = 0;
        if(s.charAt(left) == s.charAt(right)) ans = solve(s, left+1, right-1, dp);
        else ans = Math.min(1 + solve(s, left+1, right, dp), 1 + solve(s, left, right-1, dp));
        return dp[left][right] = ans;
    }
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) Arrays.fill(dp[i], -1);
        return solve(s, 0, s.length()-1, dp);
    }
}