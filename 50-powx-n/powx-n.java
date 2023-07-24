class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double ans = 1.0;
        if(Math.abs(n) % 2 != 0) ans = x;
        double t = myPow(x, Math.abs(n/2));
        return n >=0 ? ans * t * t : 1 / (ans * t * t);
    }
}