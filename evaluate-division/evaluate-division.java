class Solution {
    double dfs(String src, String dest, Map<String, Map<String, Double>> map, Set<String> set, double value) {
        set.add(src);
        if(map.containsKey(src)) {
            if(map.get(src).containsKey(dest)) return value * map.get(src).get(dest);
            for(var neigh : map.get(src).entrySet()) {
                String node = neigh.getKey();
                double val = neigh.getValue();
                if(!set.contains(node)) {
                    double ans = dfs(node, dest, map, set, value * val);
                    if(ans > 0) return ans;
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var map = new HashMap<String, Map<String, Double>>();
        for(int i=0; i<equations.size(); i++) {
            var list = equations.get(i);
            map.computeIfAbsent(list.get(0), a -> new HashMap<>()).put(list.get(1), values[i]);
            map.computeIfAbsent(list.get(1), a -> new HashMap<>()).put(list.get(0), 1/values[i]);
        }
        var ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            var query = queries.get(i);
            ans[i] = dfs(query.get(0), query.get(1), map, new HashSet<>(), 1.0);
        }
        return ans;
    }
}