class Solution {
    public int minCostConnectPoints(int[][] points) {
        var adj = new ArrayList<List<Pair<Integer, Integer>>>();
        for(int i=0; i<points.length; i++) adj.add(new ArrayList<>());
        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                adj.get(i).add(new Pair<>(Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]), j));
                adj.get(j).add(new Pair<>(Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]), i));
            }
        }
        var pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0], b[0]));
        int ans = 0;
        boolean[] vis = new boolean[points.length];
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()) {
            int cost = pq.peek()[0];
            int node = pq.poll()[1];
            if(vis[node]) continue;
            ans += cost;
            vis[node] = true;
            for(var edge : adj.get(node)) {
                int c = edge.getKey();
                int neigh = edge.getValue();
                if(!vis[neigh]) {
                    pq.add(new int[]{c, neigh});
                }
            }
        }
        return ans;
    }
}