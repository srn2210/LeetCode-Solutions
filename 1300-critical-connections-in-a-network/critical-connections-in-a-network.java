class Solution {
    int time;
    int[] low;
    int[] disc;
    List<List<Integer>> bridges;
    List<List<Integer>> graph;
    void dfs(int u, int p) {
        low[u] = disc[u] = ++time;
        for(int v : graph.get(u)) {
            if(v == p) continue;
            if(disc[v] == 0) {
                dfs(v, u);
                if(disc[u] < low[v]) {
                    bridges.add(List.of(u, v));
                }
                low[u] = Math.min(low[u], low[v]);
            }
            else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        disc = new int[n];
        bridges = new ArrayList<>();
        graph = new ArrayList<List<Integer>>(n);
        time = 0;
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(var con : connections) {
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }
        for(int i=0; i<n; i++) {
            if(disc[i] == 0) {
                dfs(i, i);
            }
        }
        return bridges;
    }
}