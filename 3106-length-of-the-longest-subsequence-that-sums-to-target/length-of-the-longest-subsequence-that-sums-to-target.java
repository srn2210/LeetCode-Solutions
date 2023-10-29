class Solution {
    int[][] dp;
    int solve(List<Integer> nums, int idx, int target, int curr) {
        if(curr > target) return -1000;
        if(idx == nums.size()) {
            if(curr == target) return 0;
            else return -1000;
        }
        if(dp[idx][curr] != -1) return dp[idx][curr];
        return dp[idx][curr] = Math.max(solve(nums, idx+1, target, curr), 1 + solve(nums, idx+1, target, curr + nums.get(idx)));
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new int[nums.size()][target+1];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        int ans = solve(nums, 0, target, 0);
        return ans < 0 ? -1 : ans;
    }
}