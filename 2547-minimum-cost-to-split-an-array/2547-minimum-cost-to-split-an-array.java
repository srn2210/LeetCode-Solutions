class Solution {
    int solve(int[] nums, int k, int[][] trimmed, int[] dp, int idx, int n) {
        if(idx >= n) return 0;
        if(dp[idx] != 0) return dp[idx];
        int ans = Integer.MAX_VALUE;
        for(int i=idx; i<n; i++) {
            ans = Math.min(ans, solve(nums, k, trimmed, dp, i+1, n) + trimmed[idx][i] + k);
        }
        return dp[idx] = ans;
    }
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[][] trimmed = new int[n][n];
        for(int i=0; i<n; i++) {
            int cnt = 0;
            int[] map = new int[1001];
            for(int j=i; j<n; j++) {
                if(++map[nums[j]] > 1) cnt += map[nums[j]] == 2 ? 2 : 1;
                trimmed[i][j] = cnt;
            }
        }
        int[] dp = new int[n];
        return solve(nums, k, trimmed, dp, 0, n);
    }
}