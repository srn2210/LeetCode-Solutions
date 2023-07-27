class Solution {
    boolean safe(long cand, int n, int[] batteries) {
        long curr = 0;
        for(int i : batteries) {
            curr += Math.min(i, cand);
        }
        return curr >= (cand * n);
    }
    public long maxRunTime(int n, int[] batteries) {
        long left = 0, right = (long)1e14;
        while(left < right) {
            long mid = (left + (right - left) / 2) + 1;
            if(safe(mid, n, batteries)) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}