class Solution {
    class UF {
        int[] arr;
        int[] sz;
        UF(int n) {
            arr = new int[n];
            sz = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                sz[i] = 1;
            }
        }
        int find(int i) {
            if(i == arr[i]) return i;
            return arr[i] = find(arr[i]);
        }
        boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }
        void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);
            if(sz[root1] < sz[root2]) {
                arr[root1] = arr[root2];
                sz[root2] += sz[root1];
            }
            else {
                arr[root2] = arr[root1];
                sz[root1] += sz[root2];
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UF obj = new UF(n);
        for(int[] i : edges) {
            obj.union(i[0], i[1]);
        }
        return obj.isConnected(source, destination);        
    }
}