class Solution {
    int solve(int[] arr, int i, int took, int[][] memo) {
        if(i == arr.length) return 0;
        if(memo[i][took] != Integer.MIN_VALUE) return memo[i][took];
        return memo[i][took] = Math.max(arr[i] * took + solve(arr, i+1, took + 1, memo), solve(arr, i+1, took, memo));
    }
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] memo = new int[n][n+1];
        for(int i=0; i<n; i++) Arrays.fill(memo[i], Integer.MIN_VALUE);
        return solve(satisfaction, 0, 1, memo);
    }
}