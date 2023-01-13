class Solution {
    int ans = 1;
    int dfs(Map<Integer, List<Integer>>adj, int[] parent, String s, int idx) {
        if(adj.get(idx) == null) return 1;
        int x = 0;
        int y = 0;
        for(int i : adj.get(idx)) {
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
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=1; i<parent.length; i++) adj.computeIfAbsent(parent[i], a -> new ArrayList<>()).add(i);
        dfs(adj, parent, s, 0);
        return ans;
    }
}