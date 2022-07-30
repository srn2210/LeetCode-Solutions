class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}