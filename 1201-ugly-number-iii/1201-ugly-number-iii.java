class Solution {
    long gcd(long a, long b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long x, long y) {
        /*long lo = Math.min(x, Math.min(y, z)), hi = x * y * z;
        //System.out.println(lo + " - " + hi);
        long ans = 1;
        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if(mid % x == 0 && mid % y == 0 && mid % z == 0) {
                ans = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ans;*/
        long ans = gcd(x, y);
        //System.out.println(ans);
        return (x * y) / ans;
    }
    int check(int mid, int n, int a, int b, int c) {
        long ab = lcm(a, b), bc = lcm(b, c), ca = lcm(a, c), abc = lcm(a, lcm(b, c));
        long ans = (mid / a) + (mid / b) + (mid / c) - (mid / ab) - (mid / bc) - (mid / ca) + (mid / abc);
        //System.out.println(ab + " - " + bc + " - " + ca + " - " + abc);
        //System.out.println(ans);
        return (int)ans;
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = (int)2e9;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int ans = check(mid, n, a, b, c);
            //if(ans == n) return mid;
            if(ans >= n) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}