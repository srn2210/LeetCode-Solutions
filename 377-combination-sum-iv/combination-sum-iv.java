class Solution {
    int solve(int[] nums, int target, int curr, int[] dp) {
        if(curr == target) return 1;
        if(curr > target) return 0;
        if(dp[curr] != -1) return dp[curr];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans += solve(nums, target, curr + nums[i], dp);
        }
        return dp[curr] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        return solve(nums, target, 0, dp);
    }
}