class Graph {

    int[][] graph;
    int n;

    public Graph(int n, int[][] edges) {
        graph = new int[n][n];
        this.n = n;
        for(int[] g : graph) Arrays.fill(g, (int)1e8);
        for(int i=0; i<edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
        }

        for(int i=0; i<n; i++) graph[i][i] = 0;

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        
    }
    
    public void addEdge(int[] edge) {
        int e1 = edge[0];
        int e2 = edge[1];
        int cost = edge[2];

        if(graph[e1][e2] > cost) {
            //graph[e1][e2] = cost;
            updDist(e1, e2, cost);
        }
    }

    void updDist(int u, int v, int c) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][u] + graph[v][j] + c < graph[i][j]) {
                    graph[i][j] = graph[i][u] + graph[v][j] + c;
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return graph[node1][node2] == (int)1e8 ? -1 : graph[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */