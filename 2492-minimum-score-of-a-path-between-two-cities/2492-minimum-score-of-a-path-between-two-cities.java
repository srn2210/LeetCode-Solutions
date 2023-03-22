class Solution {
    class UnionFind {
        int[] arr;
        int[] sz;
        UnionFind(int n) {
            arr = new int[n+1];
            sz = new int[n+1];
            for(int i=0; i<=n; i++) {
                arr[i] = i;
                sz[i] = 1;
            }
        }
        int find(int p) {
            if(p == arr[p]) return p;
            else return arr[p] = find(arr[p]);
        }
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(isConnected(p,q)) return;
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
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n);
        for(var road : roads) {
            uf.union(road[0], road[1]);
        }
        int ans = Integer.MAX_VALUE;
        for(var road : roads) {
            if(uf.isConnected(road[0], 1)) ans = Math.min(ans, road[2]);
        }
        return ans;
    }
}