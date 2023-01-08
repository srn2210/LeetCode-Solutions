class Solution {
    public int maxPoints(int[][] points) {
        double m;
        if(points.length == 1) return 1;
        int ans = 0;
        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j=i+1; j<points.length; j++) {
                if(i == j) continue;
                m = ((double)points[j][1] - points[i][1]) / ((double)points[j][0] - points[i][0]);
                if(m == -0.0) m = 0.0;
                if(points[j][0] == points[i][0]) m = Double.MAX_VALUE;
                map.put(m, map.getOrDefault(m, 0) + 1);
                ans = Math.max(ans, map.get(m));
            }
        }
        return ans + 1;
    }
}