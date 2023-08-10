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
        var pq = new PriorityQueue<List<Integer>>((a,b) -> Integer.compare(a.get(0), b.get(0)));
        int ans = 0;
        boolean[] vis = new boolean[points.length];
        int edgeCount = 0;
        pq.add(List.of(0, 0));
        while(!pq.isEmpty()) {
            var list = pq.poll();
            int cost = list.get(0);
            int node = list.get(1);            
            if(edgeCount == points.length) break;
            if(!vis[node]) {
                ans += cost;
                edgeCount++;
                vis[node] = true;
            }
            for(var edge : adj.get(node)) {
                int c = edge.getKey();
                int neigh = edge.getValue();
                if(!vis[neigh]) {
                    pq.add(List.of(c, neigh));
                }
            }
        }
        return ans;
    }
}