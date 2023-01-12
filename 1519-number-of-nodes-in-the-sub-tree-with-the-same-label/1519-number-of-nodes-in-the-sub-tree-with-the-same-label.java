class Solution {
    int[] ans;
    int[] dfs(String labels, List<Integer>[] adj, int[] alpha, int start, int prev) {
        for(int i : adj[start]) {
            if(i != prev) {
                int[] temp = dfs(labels, adj, new int[26], i, start);
                for(int j=0; j<26; j++) {
                    alpha[j] = alpha[j] + temp[j];
                }
            }
        }
        alpha[labels.charAt(start)-'a']++;
        ans[start] += alpha[labels.charAt(start)-'a'];
        return alpha;
    }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ans = new int[n];
        List<Integer>[] adj = new List[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge:edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(labels, adj, new int[26], 0, -1);
        return ans;
    }
}