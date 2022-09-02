class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }            
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}