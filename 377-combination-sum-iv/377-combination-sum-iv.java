class Solution {
    int helper(int[] arr, int rem, int[] dp) {
        if(dp[rem] != -1) return dp[rem];
        int res = 0;
        for(int i=0; i<arr.length; i++) {
            if(rem >= arr[i]) {
                res += helper(arr, rem - arr[i], dp);
            }
        }
        dp[rem] = res;
        return dp[rem];
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        helper(nums, target, dp);
        
        return dp[target];
    }
}