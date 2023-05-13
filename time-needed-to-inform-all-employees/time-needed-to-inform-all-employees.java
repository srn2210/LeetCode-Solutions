class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        var map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<n; i++) {
            if(manager[i] != -1) map.computeIfAbsent(manager[i], a -> new ArrayList<>()).add(i);
        }
        var q = new LinkedList<Pair<Integer, Integer>>();
        q.add(new Pair<>(headID, 0));
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var p = q.poll();
                int node = p.getKey();
                int cost = p.getValue();
                ans = Math.max(cost, ans);
                if(!map.containsKey(node)) continue;
                for(int i : map.get(node)) {
                    q.add(new Pair(i, cost + informTime[node]));
                }
            }
        }
        return ans;
    }
}