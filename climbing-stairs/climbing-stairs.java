class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int x = 1, y = 2;
        int t = 0;
        for(int i=3; i<=n; i++) {
            t = x + y;
            x = y;
            y = t;
        }
        return t;
    }
}