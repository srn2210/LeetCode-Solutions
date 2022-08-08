class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //TreeMap<Integer, Integer> tm = new TreeMap();
        int ans = Integer.MIN_VALUE;
        
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j>=0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            
            dp[i] += 1;
            
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}