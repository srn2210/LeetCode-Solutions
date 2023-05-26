class Solution {
    int[] pre;
    int solve(int[] piles, int idx, int M, int[][] dp) {
        if(idx >= piles.length) return 0;
        if(dp[idx][M] != -1) return dp[idx][M];
        int ans = -1000000, s = 0;
        for(int i=1; i<=2*M; i++) {
            if(i + idx - 1 >= piles.length) break;
            s += piles[idx + i - 1];
            ans = Math.max(ans, s - solve(piles, idx + i, Math.max(M, i), dp));
        }
        return dp[idx][M] = ans;
    }
    public int stoneGameII(int[] piles) {
        int[][] dp = new int[piles.length][piles.length+1];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int total = 0;
        for(int i : piles) total += i;
        return (solve(piles, 0, 1, dp) + total) / 2;
    }
}