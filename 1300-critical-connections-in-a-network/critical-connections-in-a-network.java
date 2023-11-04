class Solution {
    int time;
    int[] low;
    int[] disc;
    List<List<Integer>> bridges;
    List<Integer>[] graph;
    void dfs(int u, int p) {
        low[u] = disc[u] = ++time;
        for(int v : graph[u]) {
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
        graph = new ArrayList[n];
        time = 0;
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(var con : connections) {
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }
        for(int i=0; i<n; i++) {
            if(disc[i] == 0) {
                dfs(i, i);
            }
        }
        return bridges;
    }
}