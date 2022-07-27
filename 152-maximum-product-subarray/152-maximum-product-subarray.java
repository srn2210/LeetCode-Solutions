class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums,0,dp,0,nums.length);
        System.arraycopy(nums,0,nums2,0,nums.length);
        int max = nums[0];
        
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] == 0) continue;
            nums[i] = nums[i] * nums[i-1];
        }
        
        for(int i=nums2.length-2; i>=0; i--){
            if(nums2[i+1] == 0) continue;
            nums2[i] = nums2[i] * nums2[i+1];
        }
        
        for(int i=0; i<nums.length; i++){
            dp[i] = Math.max(dp[i], nums[i]);
            if(dp[i] > max) max = dp[i];
        }
        
        for(int i=0; i<nums.length; i++){
            dp[i] = Math.max(dp[i], nums2[i]);
            if(dp[i] > max) max = dp[i];
        }
        
        return max;
    }
}