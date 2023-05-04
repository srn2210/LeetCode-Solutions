class Solution {
    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long x, long y) {
        long ans = gcd(x, y);
        return (x * y) / ans;
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = (int)2e9;
        long ab = lcm(a, b), bc = lcm(b, c), ca = lcm(a, c), abc = lcm(a, lcm(b, c));
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long ans = (mid / a) + (mid / b) + (mid / c) - (mid / ab) - (mid / bc) - (mid / ca) + (mid / abc);
            if((int)ans >= n) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}