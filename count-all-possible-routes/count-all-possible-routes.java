class Solution {
    int mod = (int)1e9+7;
    int[][] dp;
    int solve(int[] locations, int src, int end, int fuel) {
        if(dp[src][fuel] != -1) return dp[src][fuel];
        long ans = 0;
        if(src == end) ans = 1;
        for(int i=0; i<locations.length; i++) {
            if(fuel >= Math.abs(locations[src]-locations[i]) && i != src) {
                ans += solve(locations, i, end, fuel - Math.abs(locations[src]-locations[i])) % mod;
                ans %= mod;
            }
        }
        return dp[src][fuel] = (int)(ans % mod);
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new int[locations.length][fuel+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return solve(locations, start, finish, fuel);
    }
}