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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        var ans = new boolean[queries.length];
        //mparator sort = new Comparator();
        Arrays.sort(edgeList, (a,b) -> Integer.compare(a[2], b[2]));
        int[][] queriesIndexed = new int[queries.length][4];
        
        for(int i=0; i<queries.length; i++) {
            queriesIndexed[i][0] = queries[i][0];
            queriesIndexed[i][1] = queries[i][1];
            queriesIndexed[i][2] = queries[i][2];
            queriesIndexed[i][3] = i;
        }
        Arrays.sort(queriesIndexed, (a,b) -> Integer.compare(a[2], b[2]));
        
        int edgeIndex = 0;
        for(var query : queriesIndexed) {
            int src = query[0];
            int dest = query[1];
            int limit = query[2];
            int queryIndex = query[3];
            while(edgeIndex < edgeList.length && edgeList[edgeIndex][2] < limit) {
                uf.union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            if(uf.isConnected(src, dest)) ans[queryIndex] = true;
        }
        return ans;
    }
}