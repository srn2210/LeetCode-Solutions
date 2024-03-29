class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = -1;
        for(int num : nums) max = Math.max(max, num);
        int count = 0, left = 0, right = 0;
        long ans = 0;
        while(right < nums.length) {
            if(nums[right] == max) count++;
            while(count >= k) {
                if(nums[left] == max) count--;
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        long total = (long)nums.length * (nums.length+1) / 2;
        ans = total - ans;
        return ans;
    }
}