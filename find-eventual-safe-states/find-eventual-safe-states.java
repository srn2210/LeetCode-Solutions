class Solution {
    boolean dfs(int src, int[][] g, boolean[] vis, boolean[] safe) {
        if(safe[src]) return true;
        for(int d : g[src]) {
            if(vis[d] && !safe[d]) return false;
            if(!vis[d]) {
                vis[d] = true;
                if(!dfs(d, g, vis, safe)) return false;
            }
        }
        return safe[src] = true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        var safe = new boolean[n];
        var vis = new boolean[n];
        for(int i=0; i<n; i++) {
            int[] g = graph[i];
            if(g.length == 0) {
                safe[i] = true;
                vis[i] = true;
            }
        }
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                vis[i] = true;
                dfs(i, graph, vis, safe);
            }
        }
        var ans = new ArrayList<Integer>();
        for(int i=0; i<n; i++) if(safe[i]) ans.add(i);
        return ans;
    }
}