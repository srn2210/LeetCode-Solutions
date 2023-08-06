class Solution {
    boolean flag = false;
    void dfs(int src, List<List<Integer>> adj, int[] visited, Stack<Integer> st) {
        visited[src] = 1;
        for(int neigh : adj.get(src)) {
            if(visited[neigh] == 1) flag = true;
            else if(visited[neigh] == 0) dfs(neigh, adj, visited, st);
            else continue;
        }
        st.push(src);
        visited[src] = 2;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adj = new ArrayList<List<Integer>>();
        var ans = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        var st = new Stack<Integer>();
        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if(visited[i] == 0) {
                dfs(i, adj, visited, st);
            }
        }
        if(flag) return new int[0];
        int ptr = 0;
        while(!st.isEmpty()) ans[ptr++] = st.pop();
        return ans;
    }
}