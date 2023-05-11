class Solution {
    int solve(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp) {
        if(idx1 == nums1.length || idx2 == nums2.length) return 0;
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int ans = 0;
        if(nums1[idx1] == nums2[idx2]) ans = 1 + solve(nums1, nums2, idx1+1, idx2+1, dp);
        else {
            ans = Math.max(solve(nums1, nums2, idx1+1, idx2, dp), solve(nums1, nums2, idx1, idx2+1, dp));
        }
        return dp[idx1][idx2] = ans;
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i=0; i<dp.length; i++) Arrays.fill(dp[i], -1);
        return solve(nums1, nums2, 0, 0, dp);
    }
}