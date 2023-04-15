class Graph {
    int size;
    int[][] shortest;
    int max = Integer.MAX_VALUE;
    
    void floydWarshall() {
        for(int k=0; k<size; k++) {
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(i == j) shortest[i][j] = 0;
                    if(shortest[i][k] != max && shortest[k][j] != max && shortest[i][k] + shortest[k][j] < shortest[i][j]) shortest[i][j] = shortest[i][k] + shortest[k][j];
                }
            }
        }
    }
    
    public Graph(int n, int[][] edges) {
        size = n;
        shortest = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(shortest[i], max);
        for(int[] edge : edges) shortest[edge[0]][edge[1]] = edge[2];
        floydWarshall();
    }
    
    public void addEdge(int[] edge) {
        if(edge[2] < shortest[edge[0]][edge[1]]) {
            shortest[edge[0]][edge[1]] = edge[2];
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    if(shortest[i][edge[0]] != max && shortest[edge[1]][j] != max)shortest[i][j] = Math.min(shortest[i][j], shortest[i][edge[0]] + shortest[edge[1]][j] + edge[2]);
                }
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return shortest[node1][node2] == max ? -1 : shortest[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */