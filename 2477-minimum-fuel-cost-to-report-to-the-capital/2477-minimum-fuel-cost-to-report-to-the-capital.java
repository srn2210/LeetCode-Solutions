class Solution {
    long[] dfs(List<List<Integer>> adj, int seats, int src, boolean[] vis) {
        if(adj.get(src).size() == 1 && src != 0) {
            vis[src] = true;
            return new long[]{1,1};
        }
        long[] ans = new long[2];
        for(int i : adj.get(src)) {
            if(!vis[i]) {
                vis[i] = true;
                var t = dfs(adj, seats, i, vis);
                ans[0] += t[0];
                ans[1] += t[1];
            }
        }
        if(src != 0) {
            ans[0] += 1;
            ans[1] += (long)Math.ceil(ans[0]/(double)seats);
        }
        return ans;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        var adj = new ArrayList<List<Integer>>();
        for(int i=0; i<=roads.length; i++) adj.add(new ArrayList<>());
        for(int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        var vis = new boolean[roads.length+1];
        vis[0] = true;
        return dfs(adj, seats, 0, vis)[1];
    }
}