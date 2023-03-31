class Solution {
    int mod = (int) 1e9+7;
    boolean validate(String[] pizza, int startRow, int endRow, int startCol, int endCol) {
        for(int i=startRow; i<=endRow; i++) {
            for(int j=startCol; j<=endCol; j++) {
                if(pizza[i].charAt(j) == 'A') return true;
            }
        }
        return false;
    }
    int solve(String[] pizza, int target, int startRow, int endRow, int startCol, int endCol, int[][][] dp) {
        if(target == 0) return validate(pizza, startRow, endRow, startCol, endCol) ? 1 : 0;
        if(startRow > endRow || startCol > endCol) return 0;
        if(dp[startRow][startCol][target] != -1) return dp[startRow][startCol][target];
        int sum = 0;
        for(int i=startRow; i<=endRow; i++) {
            if(validate(pizza, startRow, i, startCol, endCol)) {
                sum += solve(pizza, target-1, i+1, endRow, startCol, endCol, dp);
                sum %= mod;
            }
        }
        for(int i=startCol; i<=endCol; i++) {
            if(validate(pizza, startRow, endRow, startCol, i)) {
                sum += solve(pizza, target-1, startRow, endRow, i+1, endCol, dp);
                sum %= mod;
            }
        }
        return dp[startRow][startCol][target] = sum;
    }
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][][] dp = new int[m][n][k];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                Arrays.fill(dp[i][j], -1);
        return solve(pizza, k-1, 0, m-1, 0, n-1, dp);
    }
}