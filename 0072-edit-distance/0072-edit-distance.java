class Solution {
    int solve(String w1, String w2, int i, int j, int[][] dp, int m, int n) {
        if(i == m) return n - j;
        if(j == n) return m - i;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(w1.charAt(i) == w2.charAt(j)) {
            ans = solve(w1, w2, i+1, j+1, dp, m, n);
        }
        else {
            int a = solve(w1, w2, i+1, j+1, dp, m, n);
            int b = solve(w1, w2, i+1, j, dp, m, n);
            ans = Math.min(Math.min(a,b), solve(w1, w2, i, j+1, dp, m, n)) + 1;
        }
        return dp[i][j] = ans;
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(dp[i], -1);
        return solve(word1, word2, 0, 0, dp, m, n);
    }
}