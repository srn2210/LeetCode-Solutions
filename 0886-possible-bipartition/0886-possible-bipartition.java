class Solution {
    class UnionFind {
        int[] arr;
        int[] size;
        UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                size[i] = 1;
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
            int x = find(i);
            int y = find(j);
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> map = new ArrayList<>();
        for(int i=0; i<=n; i++) map.add(new ArrayList<>());
        UnionFind obj = new UnionFind(n+1);
        for(int[] i : dislikes) {
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        for(int i=1; i<=n; i++) {
            if(map.get(i) == null) continue;
            for(int j : map.get(i)) {
                if(obj.find(i) == obj.find(j)) return false;
                obj.union(map.get(i).get(0), j);
            }
        }
        return true;
    }
}