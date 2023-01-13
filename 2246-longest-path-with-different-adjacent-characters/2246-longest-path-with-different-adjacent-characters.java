class Solution {
    int ans = 1;
    int dfs(List<Integer>[] adj, int[] parent, String s, int idx) {
        if(adj[idx].size() == 0) return 1;
        int x = 0;
        int y = 0;
        for(int i : adj[idx]) {
            int t = dfs(adj, parent, s, i);
            if(s.charAt(i) != s.charAt(idx) && t > x) {
                if(x > y) y = x;
                x = t;
            }
            else if(s.charAt(i) != s.charAt(idx) && t > y) {
                if(y > x) x = y;
                y = t;
            }
        }
        ans = Math.max(ans, x + y + 1);
        return Math.max(x, y) + 1;
    }
    public int longestPath(int[] parent, String s) {
        List<Integer> adj[] = new List[parent.length];
        for(int i=0; i<parent.length; i++) adj[i] = new ArrayList<>();
        for(int i=1; i<parent.length; i++) adj[parent[i]].add(i);
        dfs(adj, parent, s, 0);
        return ans;
    }
}