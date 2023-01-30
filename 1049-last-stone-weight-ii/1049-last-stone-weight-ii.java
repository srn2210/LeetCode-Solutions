class Solution {
    int solve(int[] stones, int max, Map<Integer, Integer>[] dp, int idx, int[] suff) {
        if(idx == stones.length) return max;
        if(dp[idx].containsKey(max)) return dp[idx].get(max);
        int ans = Integer.MAX_VALUE;
        if(stones[idx] - max <= suff[idx]) ans = Math.min(ans, solve(stones, max - stones[idx], dp, idx + 1, suff));
        ans = Math.min(ans, solve(stones, max + stones[idx], dp, idx + 1, suff));
        dp[idx].put(max, ans);
        return ans;
    }
    public int lastStoneWeightII(int[] stones) {
        int[] suff = new int[stones.length];
        for(int i=stones.length-2; i>=0; i--) suff[i] = suff[i+1] + stones[i+1];
        Map<Integer, Integer>[] dp = new Map[stones.length];
        for(int i=0; i<dp.length; i++) dp[i] = new HashMap<>();
        return solve(stones, 0, dp, 0, suff);
    }
}