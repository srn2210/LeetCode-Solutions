class Graph {
    
    List<List<Pair<Integer, Integer>>> list;
    int n;
    int max = Integer.MAX_VALUE;
    
    public Graph(int n, int[][] edges) {
        this.n = n;
        list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(new ArrayList<>());
        for(var edge : edges) {
            list.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
    }
    
    public void addEdge(int[] edge) {
        list.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }
    
    public int shortestPath(int node1, int node2) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        var q = new PriorityQueue<Pair<Integer, Integer>>((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        q.add(new Pair(node1, 0));
        while(!q.isEmpty()) {
            int node = q.peek().getKey();
            int cost = q.poll().getValue();
            for(var neighbours : list.get(node)) {
                int adjNode = neighbours.getKey();
                int costToNeighbour = neighbours.getValue();
                if(cost + costToNeighbour < dist[adjNode]) {
                    dist[adjNode] = cost + costToNeighbour;
                    q.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist[node2] == max ? -1 : dist[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */