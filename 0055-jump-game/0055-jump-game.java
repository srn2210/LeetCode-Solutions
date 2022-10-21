class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len<2) return true;
        
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        int last = len-1;
        int i = len-1;
        
        while(i-- > 0) {
            if(nums[i] >= last - i) {
                dp[i] = true;
                last = i;
            }
            else dp[i] = false;
        }
        
        return dp[0];
    }
}