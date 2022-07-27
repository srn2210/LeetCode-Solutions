class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<2) return true;
        
        boolean[] dp = new boolean[nums.length];
        
        int last = nums.length-1;
        int i = nums.length-2;
        dp[last] = true;
        
        while(i != -1){
            if(nums[i] >= last - i){
                dp[i] = true;
                last = i;
            }
            else dp[i] = false;
            i--;
        }
        
        return dp[0];
    }
}