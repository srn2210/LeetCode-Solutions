class Solution {
    int solve(List<List<Integer>> piles, int k, int idx, int[][] prefixSum, int[][] dp) {
        if(idx >= piles.size()) return 0;
        if(dp[idx][k] != -1) return dp[idx][k];
        int ans = 0;
        for(int i=0; i<=k; i++) {
            if(i == prefixSum[idx].length) break;
            ans = Math.max(ans, prefixSum[idx][i] + solve(piles, k-i, idx+1, prefixSum, dp));
        }
        return dp[idx][k] = ans;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] prefixSum = new int[n][];
        for(int i=0; i<n; i++) {
            prefixSum[i] = new int[piles.get(i).size()+1];
            for(int j=1; j<=piles.get(i).size(); j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + piles.get(i).get(j-1);
            }
        }
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return solve(piles, k, 0, prefixSum, dp);
    }
}