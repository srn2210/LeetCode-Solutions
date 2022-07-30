class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = 0;
        int ans = Integer.MIN_VALUE;
        
        for(int i:nums) {
            max += i;
            ans = Math.max(ans, max);
            if(max < 0) max = 0;
        }
        
        return ans;
    }
}