class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n];
        long[] suf = new long[n];
        long t1 = 0, t2 = 0;
        for(int i=0; i<n; i++) {
            t1 = t1 | nums[i];
            t2 = t2 | nums[n-i-1];
            pre[i] = t1;
            suf[n-i-1] = t2;
        }
        long max = 0;
        for(int i=0; i<n; i++) {
            long x1 = i == 0 ? 0 : pre[i-1];
            long x2 = i == n-1 ? 0 : suf[i+1];
            long t = (long)nums[i] * (1 << k) | x1 | x2;
            max = Math.max(max, t);
        }
        return max;
    }
}