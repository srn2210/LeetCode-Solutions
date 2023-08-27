class Solution {
    Map<Integer, Boolean>[] dp;
    boolean solve(int[] stones, int i, int prev) {
        if(i == stones.length-1) return true;
        if(dp[i].containsKey(prev)) return dp[i].get(prev);
        if(i == 0) {
            int next = Arrays.binarySearch(stones, 1);
            if(next >= 0) return solve(stones, next, 1);
            else return false;
        }
        boolean ans = false;
        int one = Arrays.binarySearch(stones, stones[i] + prev-1);
        int two = Arrays.binarySearch(stones, stones[i] + prev);
        int three = Arrays.binarySearch(stones, stones[i] + prev+1);
        if(one >= 0 && one > i) {
            ans = ans || solve(stones, one, prev-1);
        }
        if(two >= 0 && two > i) {
            ans = ans || solve(stones, two, prev);
        }
        if(three >= 0 && three > i) {
            ans = ans || solve(stones, three, prev+1);
        }
        dp[i].put(prev, ans);
        return ans;
    }
    public boolean canCross(int[] stones) {
        dp = new Map[stones.length];
        for(int i=0; i<dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        return solve(stones, 0, 1);
    }
}