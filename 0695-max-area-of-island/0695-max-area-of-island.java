class Solution {
    class UF{
        int[] arr;
        int[] size;
        UF(int n) {
            arr = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }
        int find(int p) {
            if(p == arr[p]) return p;
            return arr[p] = find(arr[p]);
        }
        void union(int p, int q) {
            int x = find(p);
            int y = find(q);
            if(x == y) return;
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
    public int maxAreaOfIsland(int[][] grid) {
        UF obj = new UF(grid.length * grid[0].length);
        int ans = 0;
        boolean flag = false;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    flag = true;
                    if(i+1 < grid.length && grid[i+1][j] == 1) {
                        obj.union((i*grid[0].length)+j, ((i+1)*grid[0].length)+j);
                    }
                    if(j+1 < grid[0].length && grid[i][j+1] == 1) {
                        obj.union((i*grid[0].length)+j, (i*grid[0].length)+j+1);
                    }
                    ans = Math.max(ans, obj.size[obj.find((i*grid[0].length)+j)]);
                }
            }
        }
        return ans == 0 ? flag ? 1 : 0 : ans;
    }
}