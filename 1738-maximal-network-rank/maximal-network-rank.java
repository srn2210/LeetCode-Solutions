class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        var adj = new ArrayList<Set<Integer>>();
        int[][] out = new int[n][2];
        for(int i=0; i<n; i++) {
            adj.add(new HashSet<>());
            out[i][0] = i;
        }
        for(int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
            out[road[0]][1]++;
            out[road[1]][1]++;
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            int node = out[i][0];
            int edges = out[i][1];
            for(int j=0; j<n; j++) {
                int node2 = out[j][0];
                int edges2 = out[j][1];
                if(node == node2) continue;
                else {
                    int sum = edges + edges2;
                    if(adj.get(node).contains(node2)) sum--;
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans;
    }
}