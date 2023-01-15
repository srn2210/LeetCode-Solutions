class Solution {
    class UnionFind {
        int[] arr;
        int[] size;
        UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }
        int find(int p) {
            if(p == arr[p]) return p;
            else return arr[p] = find(arr[p]);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(x == y) return;
            if(size[x] > size[y]) {
                arr[y] = arr[x];
                size[x] += size[y];
            }
            else {
                arr[x] = arr[y];
                size[y] += size[x];
            }
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], a -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], a -> new ArrayList<>()).add(edge[0]);
        }
        UnionFind obj = new UnionFind(vals.length);
        Map<Integer, List<Integer>> valToNode = new TreeMap<>();
        for(int i=0; i<vals.length; i++) {
            valToNode.computeIfAbsent(vals[i], a -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for(List<Integer> value : valToNode.values()) {
            //int key = entry.getKey();
            //List<Integer> value = entry.getValue();
            for(int nodes : value) {
                if(!map.containsKey(nodes)) continue;
                for(int node : map.get(nodes)) {
                    if(vals[nodes] >= vals[node]) {
                        obj.union(nodes, node);
                    }
                }
            }
            Map<Integer, Integer> temp = new HashMap<>();
            for(int node : value) {
                temp.put(obj.find(node), temp.getOrDefault(obj.find(node), 0) + 1);
            }
            for(int val : temp.values()) {
                ans += val * (val + 1) / 2;
            }
        }
        return ans;
    }
}