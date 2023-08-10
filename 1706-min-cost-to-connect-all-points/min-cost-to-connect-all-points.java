class Solution {
    int dist(int[] a, int[] b) {
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int[][] adj = new int[points.length][points.length];
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                adj[i][j] = dist(points[i], points[j]);
                adj[j][i] = dist(points[i], points[j]);
            }
        }
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        boolean[] vis = new boolean[points.length];
        pq.add(new int[]{0, 0});
        int vertices = 0;
        while(!pq.isEmpty()) {
            int cost = pq.peek()[0];
            int node = pq.poll()[1];
            if(vertices == points.length) break;
            if(vis[node]) continue;
            vertices++;
            ans += cost;
            vis[node] = true;
            for(int i=0; i<adj[node].length; i++) {
                int c = adj[i][node];
                int neigh = i;
                if(!vis[neigh]) {
                    pq.add(new int[]{c, neigh});
                }
            }
        }
        return ans;
    }
}