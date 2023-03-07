class Solution {
    boolean check(long t, int[] arr, int total) {
        long ans = 0;
        for(int i : arr) {
            ans += t/(long)i;
        }
        return ans >= total;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : time) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        long l = (long)min;
        long r = (long)min * totalTrips;
        while(l <= r) {
            long mid = l + (r-l) / 2;
            if(check(mid, time, totalTrips)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }
        return ans;
    }
}