class Solution {
    int solve(int[] curr, int idx, int[] nums, int k, int[][] dp) {
        if(k == 1) return curr[nums.length] - curr[idx];
        if(dp[idx][k] != Integer.MAX_VALUE) return dp[idx][k];
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=idx; i<nums.length-k+1; i++) {
            sum += nums[i];
            ans = Math.min(ans, Math.max(sum, solve(curr, i+1, nums, k-1, dp)));
        }
        return dp[idx][k] = ans;
    }
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int[][] dp = new int[nums.length][k+1];
        for(int[] i:dp) Arrays.fill(i, Integer.MAX_VALUE);
        int[] presum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++) {
            presum[i] = presum[i-1] + nums[i-1];
        }
        return solve(presum, 0, nums, k, dp);
    }
}