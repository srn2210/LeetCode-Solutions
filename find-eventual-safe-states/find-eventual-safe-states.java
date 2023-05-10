class Solution {
    boolean dfs(int node, int n, int[][] graph, boolean[] vis, Set<Integer> terminal) {
        if(graph[node].length == 0) {
            if(terminal.contains(node)) {
                return true;
            }
            return false;
        }
        vis[node] = true;
        boolean ans = true;
        for(int edge : graph[node]) {
            if(!vis[edge]) {
                ans = ans && dfs(edge, n, graph, vis, terminal);
            }
            else if(vis[edge] && !terminal.contains(edge)) ans = false;
        }
        if(ans) terminal.add(node);
        return ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        var set = new HashSet<Integer>();
        for(int i=0; i<n; i++) {
            if(graph[i].length == 0) set.add(i);
        }
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(i, n, graph, vis, set);
            }
        }
        var ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }
}