class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 11001);
        dp[nums.length-1] = 0;
        int j = nums.length-2;
        
        while(j != -1){
            for(int i=0; i<nums[j]; i++){
                if(j+i+1 > nums.length-1) break;
                int temp = 1 + dp[j+i+1];
                if( dp[j] == 0 || dp[j] > temp){
                    dp[j] = temp;
                }
            }
            j--;
        }
        return dp[0];
    }
}