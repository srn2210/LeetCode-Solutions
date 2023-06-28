class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] probs = new double[n];
        probs[start] = 1.0;
        var pq = new PriorityQueue<double[]>((a,b) -> Double.compare(b[0], a[0]));
        var adj = new HashMap<Integer, List<Pair<Integer, Double>>>();
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            int src = edge[0], des = edge[1];
            adj.computeIfAbsent(src, a -> new ArrayList<>()).add(new Pair<>(des, succProb[i]));
            adj.computeIfAbsent(des, a -> new ArrayList<>()).add(new Pair<>(src, succProb[i]));
        }
        var vis = new boolean[n];
        vis[start] = true;
        pq.add(new double[]{1.0, start, start});
        while(!pq.isEmpty()) {
            var arr = pq.poll();
            int src = (int)arr[1];
            int des = (int)arr[2];
            double cost = arr[0];
            vis[des] = true;
            probs[des] = Math.max(probs[des], cost);
            if(adj.containsKey(des)) {
                for(var nei : adj.get(des)) {
                    int node = nei.getKey();
                    double c = nei.getValue();
                    if(!vis[node]) {
                        pq.add(new double[]{cost * c, des, node});
                    }
                }
            }
        }
        return probs[end];
    }
}