class Solution {
    boolean dfs(List<List<Integer>> tree, int src, int dest, Map<Integer, Integer> path, boolean[] vis, int time) {
        vis[src] = true;
        if(src == dest) {
            path.put(src, time);
            return true;
        }
        for(int node : tree.get(src)) {
            if(!vis[node]) {
                boolean res = dfs(tree, node, dest, path, vis, time+1);
                if(res) {
                    path.put(src, time);
                    return true;
                }
            }
        }
        return false;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length+1;
        var tree = new ArrayList<List<Integer>>();
        for(int i=0; i<n; i++) tree.add(new ArrayList<>());
        for(int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        boolean[] visB = new boolean[n];
        boolean[] visA = new boolean[n];
        var path = new HashMap<Integer, Integer>();
        dfs(tree, 0, bob, path, visB, 0);
        int temp = path.size()-1;
        for(var entry : path.entrySet()) {
            path.put(entry.getKey(), temp - entry.getValue());
        }
        var q = new LinkedList<Pair<Integer,Integer>>();
        q.add(new Pair<>(0, 0));
        int idxB = 0;
        visA[0] = true;

        int rest = Integer.MIN_VALUE;
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var p = q.poll();
                int node = p.getKey();
                int cost = p.getValue();
                if(!path.containsKey(node) || level < path.get(node)) {
                    cost += amount[node];
                }
                else if(level == path.get(node)) {
                    cost += amount[node] / 2;
                }
                for(int t : tree.get(node)) {
                    if(!visA[t]) {
                        visA[t] = true;
                        q.add(new Pair<>(t, cost));
                    }
                }
                if(tree.get(node).size() == 1 && node != 0) rest = Math.max(rest, cost);
            }
            level++;
        }
        return rest;
    }
}