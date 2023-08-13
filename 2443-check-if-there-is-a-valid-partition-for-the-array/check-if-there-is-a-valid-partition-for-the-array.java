class Solution {
    Boolean[] dp;
    boolean solve(int[] nums, int idx) {
        if(idx >= nums.length) return true;
        if(dp[idx] != null) return dp[idx];
        boolean ans = false;
        if(idx+1 < nums.length && nums[idx] == nums[idx+1]) ans = ans || solve(nums, idx+2);
        if(idx+2 < nums.length && nums[idx] == nums[idx+1] && nums[idx+1] == nums[idx+2]) ans = ans || solve(nums, idx+3);
        if(idx+2 < nums.length && nums[idx] + 1 == nums[idx+1] && nums[idx+1] +1 == nums[idx+2]) ans = ans || solve(nums, idx+3);
        return dp[idx] = ans;
    }
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length];
        return solve(nums, 0);
    }
}