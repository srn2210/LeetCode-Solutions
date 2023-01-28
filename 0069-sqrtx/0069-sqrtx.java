class Solution {
    public int mySqrt(int x) {
        int lo = 0;
        int hi = x;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long ans = (long)mid * mid;
            if(ans == x) return mid;
            else if(ans < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo - 1;
    }
}