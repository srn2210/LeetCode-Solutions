class Solution {
    int solve(int[] nums, int start, int end, int[][] dp) {
        if(start > end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = 0;
        ans = Math.max(nums[start] - solve(nums, start+1, end, dp), nums[end] - solve(nums, start, end-1, dp));
        return dp[start][end] = ans;
    }
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(nums, 0, nums.length-1, dp) >= 0;
    }
}