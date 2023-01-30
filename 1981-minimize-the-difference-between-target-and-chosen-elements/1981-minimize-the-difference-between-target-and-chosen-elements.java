class Solution {
    int solve(int[][] mat, int target, int[][] dp, int row, int sum) {
        if(row == mat.length) return Math.abs(target - sum);
        if(dp[row][sum] != -1) return dp[row][sum];
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<mat[0].length; i++) {
            ans = Math.min(ans, solve(mat, target, dp, row + 1, sum + mat[row][i]));
        }
        return dp[row][sum] = ans;
    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][4901];
        for(int[] i : dp)
                Arrays.fill(i, -1);
        return solve(mat, target, dp, 0, 0);
    }
}