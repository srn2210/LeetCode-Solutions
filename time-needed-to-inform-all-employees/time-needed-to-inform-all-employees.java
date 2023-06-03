class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var adj = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<n; i++) {
            if(manager[i] != -1) adj.get(manager[i]).add(i);
        }
        var q = new LinkedList<Pair<Integer, Integer>>();
        q.add(new Pair<>(headID, 0));
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var node = q.poll();
                int emp = node.getKey();
                int time = node.getValue();
                ans = Math.max(ans, time);
                for(int neigh : adj.get(emp)) {
                    q.add(new Pair<>(neigh, time + informTime[emp]));
                }
            }
        }
        return ans;
    }
}