class Solution {
    int solve(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = 0;
        ans = Math.max(solve(nums, idx+1, dp), solve(nums, idx+2, dp) + nums[idx]);
        return dp[idx] = ans;
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }
}