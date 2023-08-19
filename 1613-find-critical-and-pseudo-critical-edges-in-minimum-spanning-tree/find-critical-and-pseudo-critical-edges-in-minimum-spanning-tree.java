class Solution {
    class UF {
        int[] uf;
        int[] sz;
        int nodes;
        UF(int n) {
            uf = new int[n];
            sz = new int[n];
            nodes = 1;
            for(int i=0; i<n; i++) {
                uf[i] = i;
                sz[i] = 1;
            }
        }
        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
        int find(int x) {
            if(uf[x] == x) return x;
            else return uf[x] = find(uf[x]);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(isConnected(x, y)) return;
            else {
                nodes++;
                if(sz[x] < sz[y]) {
                    sz[y] += sz[x];
                    uf[x] = y;
                    //nodes = Math.max(nodes, sz[y]);
                }
                else {
                    uf[y] = x;
                    sz[x] += sz[y];
                    //nodes = Math.max(nodes, sz[x]);
                }
            }
        }
        int getSize() {
            return nodes;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        UF uf = new UF(n);
        int[][] indexedEdges = new int[edges.length][4];
        for(int i=0; i<edges.length; i++) {
            indexedEdges[i][0] = edges[i][0];
            indexedEdges[i][1] = edges[i][1];
            indexedEdges[i][2] = edges[i][2];
            indexedEdges[i][3] = i;
        }
        Arrays.sort(indexedEdges, (a,b) -> Integer.compare(a[2], b[2]));
        var ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int mst = 0;
        for(int i=0; i<indexedEdges.length; i++) {
            int node1 = indexedEdges[i][0];
            int node2 = indexedEdges[i][1];
            int wt = indexedEdges[i][2];
            if(!uf.isConnected(node1, node2)) {
                uf.union(node1, node2);
                mst += wt;
            }
        }
        for(int i=0; i<indexedEdges.length; i++) {
            int index = indexedEdges[i][3];

            UF t = new UF(n);
            int curr = 0;
            for(int j=0; j<indexedEdges.length; j++) {
                if(i == j) continue;
                int node1 = indexedEdges[j][0];
                int node2 = indexedEdges[j][1];
                int wt = indexedEdges[j][2];
                if(!t.isConnected(node1, node2)) {
                    t.union(node1, node2);
                    curr += wt;
                }
            }
            if(t.getSize() < n || curr > mst) {
                ans.get(0).add(index);
            }
            else {
                UF f = new UF(n);
                int curr2 = indexedEdges[i][2];
                f.union(indexedEdges[i][0], indexedEdges[i][1]);
                for(int j=0; j<indexedEdges.length; j++) {
                    if(i == j) continue;
                    int node1 = indexedEdges[j][0];
                    int node2 = indexedEdges[j][1];
                    int wt = indexedEdges[j][2];
                    if(!f.isConnected(node1, node2)) {
                        f.union(node1, node2);
                        curr2 += wt;
                    }
                }
                if(mst == curr2) ans.get(1).add(index);
            }
        }
        return ans;
    }
}