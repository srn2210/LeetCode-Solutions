class Solution {
    int[] pre;
    int solve(int[] piles, int idx, int M, int flag, int[][][] dp) {
        if(idx == piles.length) return 0;
        if(dp[idx][M][flag] != -1) return dp[idx][M][flag];
        int ans = flag == 0 ? -1 : 1000000, s = 0;
        for(int i=1; i<=Math.min(2*M, piles.length-idx); i++) {
            s += piles[idx + i - 1];
            if(flag == 0) ans = Math.max(ans, s + solve(piles, i+idx, Math.max(M, i), 1, dp));
            else ans = Math.min(ans, solve(piles, i+idx, Math.max(M, i), 0, dp));
        }
        return dp[idx][M][flag] = ans;
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length+1][2];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(piles, 0, 1, 0, dp);
    }
}