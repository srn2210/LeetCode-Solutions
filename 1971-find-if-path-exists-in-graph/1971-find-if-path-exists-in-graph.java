class Solution {
    boolean dfs(List<Integer>[] adj, int src, int dest, Set<Integer> map) {
        if(src == dest) return true;
        map.add(src);
        for(int i : adj[src]) {
            if(i == dest) return true;
            if(!map.contains(i) && dfs(adj, i, dest, map)) return true;
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++) adj[i] = new ArrayList<>();
        for(int[] i : edges) {
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        Set<Integer> set = new HashSet<>();
        return dfs(adj, source, destination, set);        
    }
}