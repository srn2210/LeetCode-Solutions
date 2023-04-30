class Solution {
    class UnionFind {
        int[] arr;
        int[] sz;
        int comp;
        UnionFind(int n) {
            comp = n-1;
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
                comp--;
                if(sz[x] < sz[y]) {
                    arr[x] = arr[y];
                    sz[y] += sz[x];
                }
                else {
                    arr[y] = arr[x];
                    sz[x] += sz[y];
                }
            }
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind uf1 = new UnionFind(n+1);
        UnionFind uf2 = new UnionFind(n+1);
        Arrays.sort(edges, (a,b) -> Integer.compare(b[0], a[0]));
        int i = 0;
        int ans = 0;
        while(i < edges.length && edges[i][0] == 3) {
            if(uf1.isConnected(edges[i][1], edges[i][2]) && uf2.isConnected(edges[i][1], edges[i][2])) ans++;
            else {
                uf1.union(edges[i][1], edges[i][2]);
                uf2.union(edges[i][1], edges[i][2]);
            }
            i++;
        }
        while(i < edges.length && edges[i][0] == 2) {
            if(uf2.isConnected(edges[i][1], edges[i][2])) ans++;
            else uf2.union(edges[i][1], edges[i][2]);
            i++;
        }
        while(i < edges.length && edges[i][0] == 1) {
            if(uf1.isConnected(edges[i][1], edges[i][2])) ans++;
            else uf1.union(edges[i][1], edges[i][2]);
            i++;
        }
        return uf1.comp == 1 && uf2.comp == 1 ? ans : -1;
    }
}