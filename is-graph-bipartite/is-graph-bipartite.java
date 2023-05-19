class Solution {
    boolean dfs(int[][] g, int src, boolean col, Boolean[] color) {
        color[src] = col;
        for(int node : g[src]) {
            if(color[node] == null) {
                if(!dfs(g, node, !col, color)) return false;
            }
            else if(color[node] == col) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        Boolean[] color = new Boolean[graph.length];
        boolean ans = true;
        for(int i=0; i<graph.length; i++) {
            if(color[i] == null) ans = ans & dfs(graph, i, true, color);
            if(!ans) return ans;
        }
        return ans;
    }
}