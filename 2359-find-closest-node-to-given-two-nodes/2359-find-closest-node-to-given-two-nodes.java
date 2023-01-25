class Solution {
    void dfs(int src, int[] adj, boolean[] vis, int[] dist) {
        if(adj[src] == -1) return;
        vis[src] = true;
        if(!vis[adj[src]]) {
            dist[adj[src]] = dist[src] + 1;
            dfs(adj[src], adj, vis, dist);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int[] dist1 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[node1] = 0;
        int[] dist2 = new int[n];
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist2[node2] = 0;
        dfs(node1, edges, vis, dist1);
        vis = new boolean[n];
        dfs(node2, edges, vis, dist2);
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0; i<n; i++) {
            int t = Math.max(dist1[i], dist2[i]);
            if(t < min) {
                min = t;
                ans = i;
            }
        }
        return ans;
    }
}