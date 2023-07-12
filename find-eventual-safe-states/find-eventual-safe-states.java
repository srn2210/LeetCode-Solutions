class Solution {
    boolean dfs(int src, int[][] g, boolean[] vis, boolean[] safe) {
        if(safe[src]) return true;
        boolean ans = true;
        //System.out.println(src);
        for(int d : g[src]) {
            if(vis[d] && !safe[d]) ans = false;
            if(!vis[d]) {
                vis[d] = true;
                //System.out.println(src + "  " + d);
                ans = dfs(d, g, vis, safe) && ans;
            }
        }
        return safe[src] = ans;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        var safe = new boolean[n];
        var vis = new boolean[n];
        for(int i=0; i<n; i++) {
            int[] g = graph[i];
            if(g.length == 0) {
                safe[i] = true;
                //vis[i] = true;
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