class Solution {
    int[][] dp;
    int solve(int[] cookies, int[] dist, int idx, int prev) {
        if(idx == cookies.length) {
            int max = Integer.MIN_VALUE;
            for(int num : dist) {
                max = Math.max(max, num);
            }
            return max;
        }
        //if(dp[idx][prev] != -1) return dp[idx][prev];
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<dist.length; i++) {
            dist[i] += cookies[idx];
            ans = Math.min(ans, solve(cookies, dist, idx+1, (1 << i)));
            dist[i] -= cookies[idx];
        }
        return dp[idx][prev] = ans;
    }
    public int distributeCookies(int[] cookies, int k) {
        dp = new int[cookies.length][1 << k];
        for(int[] d : dp) Arrays.fill(d, -1);
        int max = Integer.MAX_VALUE;
        int[] dist = new int[k];
        /*for(int i=0; i<k; i++) {
            dist[i] += cookies[i];
            max = Math.min(max, solve(cookies, dist, 1, (1 << i)));
            dist[i] -= cookies[i];
        }*/
        //return max;
        return solve(cookies, dist, 0, 0);
    }
}