class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            if(nums[0]+1 == nums[1]){
                return Math.max(nums[0], nums[1]);
            }
            else return nums[0]+nums[1];
        }
        
        Arrays.sort(nums);
        int[] dp = new int[nums[nums.length-1]+1];
        
        if(nums.length == 3){
            int temp1 = nums[2];
            int temp = nums[1];
            if(nums[0]+1 != nums[1]){
                nums[1] = nums[1] + nums[0];
            }
            if(temp+1 != nums[2]){
                nums[2] = nums[1] + nums[2];
                }
            if(temp1 == nums[2]){
                nums[2] = nums[2] + nums[0];
            }
            return Math.max(nums[1], nums[2]);
        }
        
        for(int i=0; i<nums.length; i++){
            dp[nums[i]] = dp[nums[i]] + nums[i];
        }
        
        dp[2] = dp[2] + dp[0];
        int max = Math.max(dp[1], dp[2]);
        
        
        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i] + Math.max(dp[i-2], dp[i-3]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}