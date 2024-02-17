class Solution {
    class UF {
        int[] root;
        int[] size;
        UF(int n) {
            root = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                root[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if(root[x] == x) return x;
            else return root[x] = find(root[x]);
        }
        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        void union(int x, int y) {
            if(isConnected(x, y)) return;
            int px = find(x);
            int py = find(y);
            if(size[px] > size[py]) {
                root[py] = px;
                size[px] += size[py];
            }
            else {
                root[px] = py;
                size[py] += size[px];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for(int[] edge : edges) {
            int x = edge[0]-1;
            int y = edge[1]-1;
            if(uf.isConnected(x, y)) return edge;
            else uf.union(x, y);
        }
        return new int[2];
    }
}