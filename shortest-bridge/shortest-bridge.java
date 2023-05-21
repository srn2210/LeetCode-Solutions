class Solution {
    boolean isSafe(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length && grid[row][col] == 1;
    }
    boolean isZero(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid.length;
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        var q = new LinkedList<Pair<Integer, Integer>>();
        var q2 = new LinkedList<Pair<Integer, Integer>>();
        var vis = new boolean[n][n];
        var f = false;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    vis[i][j] = true;
                    f = true;
                    break;
                }
            }
            if(f) break;
        }
        var directions = new int[]{1,0,-1,0,1};
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.peek().getKey();
                int j = q.poll().getValue();
                q2.add(new Pair(i, j));
                for(int k=0; k<4; k++) {
                    int x = i + directions[k];
                    int y = j + directions[k+1];
                    if(isSafe(x, y, grid) && !vis[x][y]) {
                        q.add(new Pair(x, y));
                        vis[x][y] = true;
                    }
                }
            }
        }
        while(!q2.isEmpty()) {
            int size = q2.size();
            while(size-- > 0) {
                int i = q2.peek().getKey();
                int j = q2.poll().getValue();
                for(int k=0; k<4; k++) {
                    int x = i + directions[k];
                    int y = j + directions[k+1];
                    if(isZero(x, y, grid) && !vis[x][y]) {
                        if(grid[x][y] == 1) return level;
                        q2.add(new Pair(x, y));
                        vis[x][y] = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}