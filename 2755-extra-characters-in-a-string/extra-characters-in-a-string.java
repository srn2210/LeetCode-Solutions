class Solution {
    int[][] dp;
    int solve(String s, Set<String> set, int left, int right) {
        if(right > s.length()) return right-left;
        if(dp[left][right] != -1) return dp[left][right];
        int ans = (int)1e9;
        if(set.contains(s.substring(left, right))) {
            ans = Math.min(solve(s, set, left, right+1), solve(s, set, right, right+1));
        }
        else {
            ans = Math.min(solve(s, set, left, right+1), right-left + solve(s, set, right, right+1));
        }
        return dp[left][right] = ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(var str : dictionary) set.add(str);
        dp = new int[s.length()+1][s.length()+1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(s, set, 0, 0)-1;
    }
}