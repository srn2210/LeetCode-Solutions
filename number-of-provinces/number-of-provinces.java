class Solution {
    class UnionFind {
        int[] arr;
        int[] size;
        int components;
        UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            components = n;
            for(int i=0; i<n; i++) {
                arr[i] = i;
                size[i] = 1;
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
                components--;
                if(size[x] < size[y]) {
                    arr[x] = arr[y];
                    size[y] += size[x];
                }
                else {
                    arr[y] = arr[x];
                    size[x] += size[y];
                }
            }
        }
        int size() {
            return components;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.size();
    }
}