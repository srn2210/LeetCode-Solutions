class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans = 1;
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int y = points[0][1];
        for(int[] point : points) {
            if(y >= point[0]) {
                y = Math.min(y, point[1]);
            }
            else {
                ans++;
                y = point[1];
            }
        }
        return ans;
    }
}