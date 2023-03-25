class Solution {
    class UnionFind {
        int[] arr;
        int[] sz;
        UnionFind(int n) {
            arr = new int[n];
            sz = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                sz[i] = 1;
            }
        }
        int find(int p) {
            if(arr[p] == p) return p;
            else return arr[p] = find(arr[p]);
        }
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(isConnected(x, y)) return;
            else {
                if(sz[x] < sz[y]) {
                    arr[x] = y;
                    sz[y] += sz[x];
                }
                else {
                    arr[y] = x;
                    sz[x] += sz[y];
                }
            }
        }
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(var edge : edges) uf.union(edge[0], edge[1]);
        var set = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
            if(!set.containsKey(uf.find(i))) set.put(uf.find(i), uf.sz[uf.find(i)]);
        }
        long t = n;
        long ans = 0;
        for(var entry : set.entrySet()) {
            int t1 = entry.getValue();
            t -= t1;
            ans += t * t1;
        }
        return ans;
    }
}