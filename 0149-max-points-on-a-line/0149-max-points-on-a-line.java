class Solution {
    public int maxPoints(int[][] points) {
        double m;
        int ans = 1;
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                m = ((double)points[j][1] - points[i][1]) / ((double)points[j][0] - points[i][0]);
                int curr = 2;
                ans = Math.max(ans, curr);
                for(int k=0; k<points.length; k++) {
                    if(k == i || k == j) continue;
                    double t = ((double)points[j][1] - points[k][1]) / ((double)points[j][0] - points[k][0]);
                    if(t == m) curr++;
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}