class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2) {
            var ans = new LinkedList<Integer>();
            for(int i=0; i<n; i++) ans.add(i);
            return ans;
        }
        var adj = new ArrayList<Set<Integer>>();
        for(int i=0; i<n; i++) adj.add(new HashSet<Integer>());
        for(var edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        var queue = new LinkedList<Integer>();
        for(int i=0; i<n; i++) if(adj.get(i).size() == 1) queue.add(i);
        while(true) {
            int size = queue.size();
            var prevQueue = new LinkedList<Integer>();
            while(size-- > 0) {
                var t = queue.poll();
                prevQueue.add(t);
                if(adj.get(t).size() == 0) continue;
                var t1 = adj.get(t).iterator().next();
                adj.get(t1).remove(t);
                if(adj.get(t1).size() == 1) queue.add(t1);
            }
            if(queue.isEmpty()) return prevQueue;
        }
    }
}