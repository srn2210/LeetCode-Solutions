class Solution {
    int solve(int[] nums, int start, int end) {
        if(start > end) return 0;
        int ans = 0;
        ans = Math.max(nums[start] - solve(nums, start+1, end), nums[end] - solve(nums, start, end-1));
        return ans;
    }
    public boolean PredictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length-1) >= 0;
    }
}