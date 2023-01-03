class Solution {
    int solve(int curr, int idx, int[] nums, int k, int[][] dp) {
        if(k == 1) {
            int sum = 0;
            for(int i=idx; i<nums.length; i++) {
                sum += nums[i];
            }
            return dp[idx][k] = Math.max(curr, sum);
        }
        if(dp[idx][k] != Integer.MAX_VALUE) return dp[idx][k];
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=idx; i<nums.length-k+1; i++) {
            sum += nums[i];
            ans = Math.min(ans, Math.max(sum, solve(sum, i+1, nums, k-1, dp)));
        }
        return dp[idx][k] = ans;
    }
    public int splitArray(int[] nums, int k) {
        //int res = Integer.MAX_VALUE;
        int sum = 0;
        int[][] dp = new int[nums.length][k+1];
        for(int[] i:dp) Arrays.fill(i, Integer.MAX_VALUE);
        return solve(0, 0, nums, k, dp);
    }
}