class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i] = new int[]{nums[i],cost[i]};
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
        long ans = (long)1e18;
        long[] pre = new long[n];
        long[] suf = new long[n];
        long cos = arr[0][1];
        for(int i=1; i<n; i++) {
            pre[i] = pre[i-1] + (cos * (arr[i][0] - arr[i-1][0]));
            cos += arr[i][1];
        }
        cos = arr[n-1][1];
        for(int i=n-2; i>=0; i--) {
            suf[i] = suf[i+1] + (cos * (arr[i+1][0] - arr[i][0]));
            cos += arr[i][1];
        }
        for(int i=0; i<n; i++) {
            ans = Math.min(ans, pre[i]+suf[i]);
        }
        return ans;
    }
}