class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int ans = -1;
        for(int i=0; i<points.length-1; i++) {
            ans = Math.max(ans, points[i+1][0] - points[i][0]);
        }
        return ans;
    }
}