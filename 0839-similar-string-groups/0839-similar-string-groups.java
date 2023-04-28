class Solution {
    class UnionFind {
        int[] arr;
        int[] sz;
        int size;
        UnionFind(int n) {
            arr = new int[n];
            sz = new int[n];
            size = n;
            for(int i=0; i<n; i++) {
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
            if(isConnected(x, y)) return;
            else {
                size--;
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
        int size() {
            return size;
        }
    }
    public int numSimilarGroups(String[] strs) {
        var uf = new UnionFind(strs.length);
        int m = strs.length;
        int n = strs[0].length();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<i; j++) {
                count = 0;
                for(int k=0; k<n; k++) {
                    if(strs[i].charAt(k) != strs[j].charAt(k)) {
                        count++;
                        if(count > 2) break;
                    }
                }
                if(count == 0 || count == 2) uf.union(i, j);
            }
        }
        return uf.size();
    }
}