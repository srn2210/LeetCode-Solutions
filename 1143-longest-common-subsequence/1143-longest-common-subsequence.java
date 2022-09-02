class Solution {
    int solve(int i, int j, String a, String b, int[][] dp) {
        int ans = 0;
        if(a.length() == i || b.length() == j)
            return 0;
        
        else if(dp[i][j] != -1)
            return dp[i][j];
        
        else if(a.charAt(i) == b.charAt(j)) {
            dp[i][j] = 1 + solve(i+1, j+1, a, b, dp);
            ans = Math.max(ans, dp[i][j]);
        }
        
        else {
            dp[i][j] = Math.max(solve(i+1, j, a, b, dp), solve(i, j+1, a, b, dp));
            ans = Math.max(ans, dp[i][j]);
        }
        
        return ans;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] i:dp) {
            Arrays.fill(i, -1);
        }
        return solve(0, 0, text1, text2, dp);
    }
}