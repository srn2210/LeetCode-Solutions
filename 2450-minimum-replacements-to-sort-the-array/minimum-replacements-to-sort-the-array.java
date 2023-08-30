class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i] <= nums[i+1]) continue;
            else {
                long t = (long)Math.ceil(nums[i] / (double)nums[i+1]);
                nums[i] = nums[i] / (int)t;
                ans += t - 1;
            }
        }
        return ans;
    }
}