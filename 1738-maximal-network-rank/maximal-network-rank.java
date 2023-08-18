class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        var adj = new ArrayList<Set<Integer>>();
        for(int i=0; i<n; i++) {
            adj.add(new HashSet<>());
        }
        for(int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        int ans = 0;
        for(int i=0; i<n; i++) {
            int node = i;
            int edges = adj.get(i).size();
            for(int j=i+1; j<n; j++) {
                int node2 = j;
                int edges2 = adj.get(j).size();
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