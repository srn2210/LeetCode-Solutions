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
            if(isConnected(p, q)) return;
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
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int unusedConnection = 0;
        for(var conn : connections) {
            if(uf.isConnected(conn[0], conn[1])) unusedConnection++;
            else uf.union(conn[0], conn[1]);
        }
        int main = 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!uf.isConnected(i, main) && unusedConnection > 0) {
                ans++;
                uf.union(i, main);
                unusedConnection--;
            }
            else if(!uf.isConnected(i, main) && unusedConnection == 0) return -1;
        }
        return ans;
    }
}