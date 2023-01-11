class Solution {
    int dfs(List<Integer>[] adj, List<Boolean> check, int start, boolean[] visited) {
        if(adj[start].size() == 0) return check.get(start) ? 2 : 0;
        int ans = 0;
        for(int i : adj[start]) {
            if(!visited[i]) {
                visited[i] = true;
                ans += dfs(adj, check, i, visited);
            }
        }
        if((check.get(start) || ans > 0) && start != 0) ans += 2;
        return ans;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new List[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        visited[0] = true;
        return dfs(adj, hasApple, 0, visited);
    }
}