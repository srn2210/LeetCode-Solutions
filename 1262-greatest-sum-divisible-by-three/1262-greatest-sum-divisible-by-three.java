class Solution {
    int solve(int[] nums, int idx, int rem, int[][] dp) {
        if(idx == nums.length) return rem == 0 ? 0 : -1000000000;
        if(dp[idx][rem] != -1) return dp[idx][rem];
        int t1 = nums[idx] + solve(nums, idx + 1, (rem + nums[idx]) % 3, dp);
        int t2 = solve(nums, idx + 1, rem, dp);
        return dp[idx][rem] = Math.max(t1,t2);
    }
    public int maxSumDivThree(int[] nums) {
        var dp = new int[nums.length][3];
        for(int i=0; i<nums.length; i++) Arrays.fill(dp[i], -1);
        return solve(nums, 0, 0, dp);
    }
}