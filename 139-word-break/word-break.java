class Solution {
    Boolean[] dp;
    boolean solve(String s, Set<String> set, int curr) {
        if(curr >= s.length()) return true;
        if(dp[curr] != null) return dp[curr];
        boolean ans = false;
        for(int i=curr; i<=s.length(); i++) {
            ans = ans || (set.contains(s.substring(curr, i)) && solve(s, set, i));
        }
        return dp[curr] = ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        var set = new HashSet<String>(wordDict);
        dp = new Boolean[s.length()];
        return solve(s, set, 0);
    }
}