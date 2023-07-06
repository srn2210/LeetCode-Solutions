class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int max = 100001, left = 0, right = 0, sum = 0, ans = max;
        while(right < nums.length) {
            sum += nums[right];
            while(left <= right && sum >= target) {
                ans = Math.min(ans, right-left+1);
                sum -= nums[left++];
            }
            right++;
        }
        return ans == max ? 0 : ans;
    }
}