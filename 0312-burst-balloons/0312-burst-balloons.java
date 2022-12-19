class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i : nums) if(i != 0) arr.add(i);
        arr.add(1);
        int dp[][] = new int[arr.size()][arr.size()];
        int n = dp.length;
        for(int i=1; i<n; i++) {
            for(int left=0; left<n-i; left++) {
                int right = left + i;
                for(int mid=left+1; mid<right; mid++) {
                    int l = dp[left][mid];
                    int r = dp[mid][right];
                    dp[left][right] = Math.max(dp[left][right], arr.get(left) * arr.get(mid) * arr.get(right) + l + r);
                }
            }
        }
        return dp[0][n-1];
    }
}