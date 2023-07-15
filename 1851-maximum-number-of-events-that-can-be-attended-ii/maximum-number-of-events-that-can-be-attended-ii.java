class Solution {
    Map<Integer, Map<Integer, Integer>> dp;
    int solve(int[][] events, int k, int idx, int date) {
        if(idx == events.length || k == 0) return 0;
        if(dp.containsKey(date) && dp.get(date).containsKey(k)) return dp.get(date).get(k);
        int pick = 0;
        if(date < events[idx][0]) pick = events[idx][2] + solve(events, k-1, idx+1, events[idx][1]);
        int notPick = solve(events, k, idx+1, date);
        dp.computeIfAbsent(date, a -> new HashMap<>()).put(k, Math.max(pick, notPick));
        return Math.max(pick, notPick);
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
        dp = new HashMap<Integer, Map<Integer, Integer>>();
        return solve(events, k, 0, 0);
    }
}