class Solution {
    int mod = (int)1e9+7;
    int solve(int[] nums, int prev, int mask, int[][] dp) {
        if(mask == (1 << dp.length)-1) return 1;
        if(dp[prev][mask] != -1) return dp[prev][mask];
        int ans = 0;
        for(int i=0; i<dp.length; i++) {
            int m = 1 << i;
            if((mask & m) == 0 && (nums[i] % nums[prev] == 0 || nums[prev] % nums[i] == 0)) {
                ans += solve(nums, i, mask | m, dp);
                ans %= mod;
            }
        }
        return dp[prev][mask] = ans % mod;
    }
    public int specialPerm(int[] nums) {
        int[][] dp = new int[nums.length][1 << nums.length];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            ans += solve(nums, i, 1 << i, dp);
            ans %= mod;
        }
        return ans;
    }
}