class Solution {
    int solve(int task, int[] dp) {
        if(dp[task] != 0) return dp[task];
        for(int i=5; i<=task; i++) {
            dp[i] = Math.min(dp[i-2], dp[i-3]) + 1;
        }
        return dp[task];
    }
    public int minimumRounds(int[] tasks) {
        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for(int entry : map.values()) {
            int temp = solve(entry, dp);
            if(temp == -1) return -1;
            ans += temp;
        }
        return ans;
    }
}