class Solution {
    Boolean[][] dp;
    boolean solve(String s, Set<String> set, int start, int end) {
        if(start > end) return true;
        if(dp[start][end] != null) return dp[start][end];
        boolean ans = false;
        for(int i=start; i<=end+1; i++) {
            ans = ans || (set.contains(s.substring(start, i)) && solve(s, set, i, end));
        }
        return dp[start][end] = ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        var set = new HashSet<String>(wordDict);
        dp = new Boolean[s.length()][s.length()];
        return solve(s, set, 0, s.length()-1);
    }
}