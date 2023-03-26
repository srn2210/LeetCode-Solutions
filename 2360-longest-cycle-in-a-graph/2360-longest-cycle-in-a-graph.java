class Solution {
    int ans;
    void dfs(int src, int[] edges, int[] visited, int cLength, Map<Integer, Integer> map) {
        int i = edges[src];
        //map.put(src, cLength);
        if(i != -1 && visited[i] == 1) {
            ans = Math.max(ans , cLength-map.get(i));
        }
        else if(i != -1 && visited[i] == 0) {
            visited[i] = 1;
            map.put(i, cLength);
            dfs(i, edges, visited, cLength+1, map);
        }
        
        visited[src] = 2;
        return;
    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        var map = new HashMap<Integer, Integer>();
        ans = -1;
        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                map.put(i, 0);
                dfs(i, edges, visited, 1, map);
            }
        }
        return ans;
    }
}