class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0, ans = 0;
        long curr = 0;
        while(right < nums.length) {
            curr += nums[right];
            while((long)((right - left + 1) * nums[right]) - curr > k) {
                curr -= nums[left];
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}