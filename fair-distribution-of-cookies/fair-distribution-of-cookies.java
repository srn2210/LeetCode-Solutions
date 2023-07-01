class Solution {
    int[][] dp;
    int[] c;
    int solve(int[] cookies, int k, int idx, int curr) {
        if(idx == k) {
            if(curr == (1 << cookies.length) -1) return 0;
            return (int)1e7;
        }
        if(dp[idx][curr] != -1) return dp[idx][curr];
        int ans = solve(cookies, k, idx+1, curr);
        for(int i=1; i<(1 << cookies.length); i++) {
            if((i & curr) == 0) ans = Math.min(ans, Math.max(solve(cookies, k, idx+1, curr | i), c[i]));
        }
        return dp[idx][curr] = ans;
    }
    public int distributeCookies(int[] cookies, int k) {
        dp = new int[k][1 << cookies.length];
        for(int[] d : dp) Arrays.fill(d, -1);
        int n = cookies.length;
        c = new int[1 << n];
        for(int i=0; i<(1<<n); i++) {
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) != 0) {
                    c[i] += cookies[j];
                }
            }
        }
        return solve(cookies, k, 0, 0);
    }
}