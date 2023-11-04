class Solution {
    int[] disc;
    int[] low;
    int time;

    void dfs(List<List<Integer>> graph, List<List<Integer>> ans, int u, int p) {
        disc[u] = low[u] = ++time;

        for(int v : graph.get(u)) {
            if(v == p) continue;
            if(disc[v] == 0) {
                dfs(graph, ans, v, u);
                if(disc[u] < low[v]) {
                    ans.add(List.of(u, v));
                }
                low[u] = Math.min(low[u], low[v]);
            }
            else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        var graph = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        for(var con : connections) {
            graph.get(con.get(0)).add(con.get(1));
            graph.get(con.get(1)).add(con.get(0));
        }
        disc = new int[n];
        low = new int[n];
        time = 0;
        var ans = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) {
            if(disc[i] == 0) {
                dfs(graph, ans, i, i);
            }
        }
        return ans;
    }
}