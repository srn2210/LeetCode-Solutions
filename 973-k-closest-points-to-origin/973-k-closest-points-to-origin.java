class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int z = (int) (Math.pow(x, 2) + Math.pow(y, 2));
            pq.add(new int[]{x, y, z});
        }
        
        for(int i=0; i<k; i++) {
            ans[i][0] = pq.peek()[0];
            ans[i][1] = pq.peek()[1];
            pq.poll();
        }
        
        return ans;
    }
}