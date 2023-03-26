class Solution {
    int ans;
    void dfs(int src, int[] edges, int[] visited, int cLength, int[] map) {
        int i = edges[src];
        if(i == -1) {
            visited[src] = 2;
            return;
        }
        else if(visited[i] == 1) {
            ans = Math.max(ans , cLength-map[i]);
        }
        else if(visited[i] == 0) {
            visited[i] = 1;
            map[i] = cLength;
            dfs(i, edges, visited, cLength+1, map);
        }
        
        visited[src] = 2;
        return;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        var visited = new int[n];
        var map = new int[n];
        ans = -1;
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i, edges, visited, 1, map);
            }
        }
        return ans;
    }
}