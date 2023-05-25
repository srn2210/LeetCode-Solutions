class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k == 0 || n > k - 1 + maxPts) return 1.0;
        double[] prob = new double[Math.max(maxPts+1,n+1)];
        prob[0] = 1.0;
        double s = 1.0;
        for(int i=1; i<=n; i++) {
            prob[i] = s / maxPts;
            if(i < k) s += prob[i];
            if(i - maxPts >= 0) {
                s -= prob[i-maxPts];
            }
        }
        double ans = 0.0;
        for(int i=k; i<=n; i++) ans += prob[i];
        return ans;
    }
}