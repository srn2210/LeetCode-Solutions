class Solution {
    int r;
    class UnionFind {
        int[] arr;
        int[] size;
        UnionFind(int n1) {
            int n = n1 + 2;
            arr = new int[n];
            size = new int[n];
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
            if(size[x] < size[y]) {
                size[y] += size[x];
                arr[x] = y;
            }
            else {
                size[x] += size[y];
                arr[y] = x;
            }
        }
    }
    int transform(int i, int j) {
        return ((i-1) * r) + j;
    }
    boolean notSafe(int i, int j, int r, int c) {
        return i <= 0 || c <= 0 || i > r || j > c;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        r = col;
        int last = (row * col) + 1;
        UnionFind uf = new UnionFind(row * col);
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i=cells.length-1; i>=0; i--) {
            int x = cells[i][0], y = cells[i][1];
            if(x == row) uf.union(transform(x, y), last);
            if(x == 1) uf.union(transform(x, y), 0);
            for(var dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(notSafe(newX, newY, row, col)) continue;
                else {
                    if(set.contains(new Pair<>(newX, newY))) {
                        uf.union(transform(x,y), transform(newX, newY));
                    }
                    //else set.add(new Pair<>(newX, newY));
                }
            }
            if(uf.isConnected(0, last)) return i;
            set.add(new Pair<>(x, y));
        }
        return -1;
    }
}