class Solution {
    boolean dfs(int node, int n, int[][] graph, boolean[] vis, boolean[] terminal) {
        if(graph[node].length == 0) return true;
        vis[node] = true;
        boolean ans = true;
        for(int edge : graph[node]) {
            if(!vis[edge]) {
                ans = ans && dfs(edge, n, graph, vis, terminal);
            }
            else if(vis[edge] && !terminal[edge]) return terminal[node] = false;
        }
        return terminal[node] = ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        var set = new boolean[n];
        var ans = new ArrayList<Integer>();
        var vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(graph[i].length == 0) set[i] = true;
        }
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(i, n, graph, vis, set);
            }
        }
        for(int i=0; i<n; i++) if(set[i]) ans.add(i);
        return ans;
    }
}