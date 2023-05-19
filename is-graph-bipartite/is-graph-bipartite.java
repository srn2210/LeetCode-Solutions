class Solution {
    boolean dfs(int[][] g, int src, int col, int[] color) {
        color[src] = col;
        for(int node : g[src]) {
            if(color[node] == col) return false;
            else if(color[node] == 0) {
                int t = 0;
                if(col == 1) t = 2;
                else t = 1;
                if(!dfs(g, node, t, color)) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        boolean ans = true;
        for(int i=0; i<graph.length; i++) if(color[i] == 0) ans = ans & dfs(graph, i, 1, color);
        return ans;
    }
}