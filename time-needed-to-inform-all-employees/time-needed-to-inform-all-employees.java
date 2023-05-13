class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var adj = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n; i++) if(manager[i] != -1) adj.get(manager[i]).add(i);
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[headID] = 0;
        var q = new LinkedList<Integer>();
        q.add(headID);
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int node = q.poll();
                int curr = cost[node];
                ans = Math.max(curr, ans);
                for(int i : adj.get(node)) {
                    cost[i] = curr + informTime[node];
                    q.add(i);
                }
            }
        }
        return ans;
    }
}