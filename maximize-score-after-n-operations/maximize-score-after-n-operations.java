class Solution {
    int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    int solve(int[] nums, int k, int[] dp, int[][] g, int state) {
        if(k > nums.length/2) return 0;
        if(dp[state] != -1) return dp[state];
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            if((state & 1 << i) == 0) {
                state = state | 1 << i;
                for(int j=0; j<nums.length; j++) {
                    if((state & 1 << j) == 0) {
                        state = state | 1 << j;
                        ans = Math.max(ans, k * g[i][j] + solve(nums, k+1, dp, g, state));
                        state = state ^ 1 << j;
                    }
                }
                state = state ^ 1 << i;
            }
        }
        return dp[state] = ans;
    }
    public int maxScore(int[] nums) {
        int[][] g = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length; j++) {
                g[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int[] dp = new int[1 << nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 1, dp, g, 0);
    }
}