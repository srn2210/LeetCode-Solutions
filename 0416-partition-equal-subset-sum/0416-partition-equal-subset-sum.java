class Solution {
    boolean solve(int[] nums, int idx, int curr, int target, Boolean[][] dp) {
        if(target == curr) return true;
        if(idx >= nums.length || curr > target) return false;
        if(dp[idx][curr] != null) return dp[idx][curr];
        return dp[idx][curr] = solve(nums, idx + 1, curr, target, dp) || solve(nums, idx + 1, curr + nums[idx], target, dp);
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        sum /= 2;
        return solve(nums, 0, 0, sum, new Boolean[nums.length+1][sum+1]);
    }
}