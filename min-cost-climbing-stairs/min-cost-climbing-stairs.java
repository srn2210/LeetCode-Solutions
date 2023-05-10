class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length+1;
        int x = cost[0], y = cost[1];
        int ans = 0;
        for(int i=2; i<n; i++) {
            int temp = i < n-1 ? cost[i] : 0;
            ans = Math.min(x, y) + temp;
            x = y;
            y = ans;
        }
        return ans;
    }
}