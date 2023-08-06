class Solution {
    boolean dfs(int src, Map<Integer, List<Integer>> adj, int[] visited) {
        visited[src] = 1;
        boolean ans = true;
        if(adj.containsKey(src)) {
            for(int neigh : adj.get(src)) {
                if(visited[neigh] == 1) return false;
                else if(visited[neigh] == 0) ans = ans && dfs(neigh, adj, visited);
                else continue;
            }
        }
        visited[src] = 2;
        return ans;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adj = new HashMap<Integer, List<Integer>>();
        for(int[] edge : prerequisites) {
            adj.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                if(!dfs(i, adj, visited)) return false;
            }
        }
        return true;
    }
}