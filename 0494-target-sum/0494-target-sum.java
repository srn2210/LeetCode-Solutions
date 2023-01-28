class Solution {
    int solve(int[] nums, int target, Map<Integer, Integer>[] dp, int idx) {
        if(idx == nums.length) return target == 0 ? 1 : 0;
        if(dp[idx].containsKey(target)) return dp[idx].get(target);
        int ans = 0;
        ans += solve(nums, target-nums[idx], dp, idx+1);
        ans += solve(nums, target+nums[idx], dp, idx+1);
        dp[idx].put(target, ans);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer>[] dp = new Map[nums.length];
        for(int i=0; i<nums.length; i++) dp[i] = new HashMap<>();
        return solve(nums, target, dp, 0);
    }
}