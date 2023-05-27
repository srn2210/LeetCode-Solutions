class Solution {
    int[][] dp;
    int solve(String s, int end, int start, Set<String> set) {
        if(end >= s.length() || start > end) return 0;
        if(dp[end][start] != -1) return dp[end][start];
        int ans = 0;
        if(set.contains(s.substring(start, end+1))) ans = Math.max(solve(s, end+1, start, set), end - start + 1 + solve(s, end+1, end+1, set));
        else ans = Math.max(solve(s, end+1, start+1, set), solve(s, end+1, start, set));
        return dp[end][start] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        var set = new HashSet<String>();
        for(var ss : dictionary) set.add(ss);
        dp = new int[s.length()][s.length()];
        for(int[] d : dp) Arrays.fill(d, -1);
        return s.length() - solve(s, 0, 0, set);
    }
}