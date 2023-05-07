class Solution {
    boolean check(int val, int m, int n, int k) {
        int sum = 0;
        for(int i=1; i<=m; i++) {
            sum += Math.min(n, (val / i));
        }
        return sum >= k;
    }
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(check(mid, m, n, k)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}