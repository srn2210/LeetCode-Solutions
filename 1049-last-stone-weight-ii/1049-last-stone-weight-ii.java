class Solution {
    int ans;
    int solve(int[] stones, int max, Map<Integer, Integer>[] dp, int idx) {
        if(idx == stones.length) return max;
        if(dp[idx].containsKey(max)) return dp[idx].get(max);
        //int ans = Integer.MAX_VALUE;
        int ans1 = solve(stones, max - stones[idx], dp, idx + 1);
        int ans2 = solve(stones, max + stones[idx], dp, idx + 1);
        dp[idx].put(max, Math.min(ans1, ans2));
        if(ans1 >= 0) this.ans = Math.min(this.ans, ans1);
        if(ans2 >= 0) this.ans = Math.min(this.ans, ans2);
        return Math.min(ans1, ans2);
    }
    public int lastStoneWeightII(int[] stones) {
        ans = Integer.MAX_VALUE;
        //int max = 0;
        //for(int i : stones) max += i;
        Map<Integer, Integer>[] dp = new Map[stones.length];
        for(int i=0; i<dp.length; i++) dp[i] = new HashMap<>();
        solve(stones, 0, dp, 0);
        //System.out.println(Arrays.toString(dp));
        /*for(var m : dp) {
            for(var entry : m.entrySet()) {
                if(entry.getValue() >= 0) ans = Math.min(ans, entry.getValue());
            }
        }*/
        return ans;
    }
}