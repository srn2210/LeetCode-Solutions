class Solution {
    int solve(int[] days, int[] costs, int[] dp, int i) {
        if(i == days.length) return 0;
        if(dp[i] != -1) return dp[i];
        int cost = 0;
        int x = costs[0] + solve(days, costs, dp, i+1);
        int t = 0;
        while((i+t) < days.length && days[i+t] <= days[i] + 6) t++;
        int y = costs[1] + solve(days, costs, dp, i+t);
        int a = 0;
        while((i+a) < days.length && days[i+a] <= days[i] + 29) a++;
        int z = costs[2] + solve(days, costs, dp, i+a);
        cost = Math.min(x, Math.min(y, z));
        return dp[i] = cost;
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return solve(days, costs, dp, 0);
    }
}