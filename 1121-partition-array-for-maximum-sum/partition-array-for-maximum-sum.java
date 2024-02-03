class Solution {
    int k;
    int[][] dp;
    int solve(int[] arr, int idx, int k_left, int max) {
        if(idx == arr.length) return (k - k_left) * max;
        if(dp[idx][k_left] != -1) return dp[idx][k_left];
        int ans = (k - k_left + 1) * Math.max(max, arr[idx]) + solve(arr, idx+1, k, 0);
        if(k_left > 1) ans = Math.max(ans, solve(arr, idx+1, k_left-1, Math.max(max, arr[idx])));
        return dp[idx][k_left] = ans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.k = k;
        dp = new int[arr.length][k+1];
        for(int i=0; i<arr.length; i++) Arrays.fill(dp[i], -1);
        return solve(arr, 0, k, 0);
    }
}