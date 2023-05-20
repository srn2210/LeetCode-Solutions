class Solution {
    void dfs(Map<String, List<Pair<String, Double>>> adj, String par, String src, Map<String, Map<String, Double>> map, Set<String> set, double value) {
        set.add(src);
        for(var neigh : adj.get(src)) {
            var node = neigh.getKey();
            var val = neigh.getValue();
            if(value != -1) val = val * value;
            if(!set.contains(node)) {
                if(!map.containsKey(par)) map.put(par, new HashMap<>());
                map.get(par).put(node, val);
                if(!map.containsKey(node)) map.put(node, new HashMap<>());
                map.get(node).put(par, 1/val);
                dfs(adj, par, node, map, set, val);
            }
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var map = new HashMap<String, Map<String, Double>>();
        var adj = new HashMap<String, List<Pair<String, Double>>>();
        var set = new HashSet<String>();
        for(int i=0; i<equations.size(); i++) {
            var list = equations.get(i);
            adj.computeIfAbsent(list.get(0), a -> new ArrayList<>()).add(new Pair(list.get(1), values[i]));
            adj.computeIfAbsent(list.get(1), a -> new ArrayList<>()).add(new Pair(list.get(0), 1/values[i]));
            if(!map.containsKey(list.get(0))) map.put(list.get(0), new HashMap<>());
            map.get(list.get(0)).put(list.get(1), values[i]);
            if(!map.containsKey(list.get(1))) map.put(list.get(1), new HashMap<>());
            map.get(list.get(1)).put(list.get(0), 1/values[i]);
            set.add(list.get(0));
            set.add(list.get(1));
            map.get(list.get(0)).put(list.get(0), 1.0);
            map.get(list.get(1)).put(list.get(1), 1.0);
        }
        var set2 = new HashSet<>();
        for(var node : set) {
            dfs(adj, node, node, map, new HashSet<>(), map.get(node).get(node));
        }
        var ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            var query = queries.get(i);
            if(!map.containsKey(query.get(0)) || !map.get(query.get(0)).containsKey(query.get(1))) {
                ans[i] = -1.0;
            }
            else {
                ans[i] = map.get(query.get(0)).get(query.get(1));
            }
        }
        return ans;
    }
}