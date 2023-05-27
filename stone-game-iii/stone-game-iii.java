class Solution {
    int solve(int[] arr, int idx, int[] dp) {
        if(idx >= arr.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        int ans = Integer.MIN_VALUE;
        int s = 0;
        for(int i=1; i<=3; i++) {
            if(idx + i - 1 >= arr.length) break;
            s += arr[idx+i-1];
            ans = Math.max(ans, s - solve(arr, idx+i, dp));
        }
        return dp[idx] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int[] dp = new int[stoneValue.length];
        Arrays.fill(dp, -1);
        int ans = solve(stoneValue, 0, dp);
        return ans == 0 ? "Tie" : ans > 0 ? "Alice" : "Bob";
    }
}