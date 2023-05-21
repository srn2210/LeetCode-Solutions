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
                    q2.add(new Pair(i, j));
                    f = true;
                    break;
                }
            }
            if(f) break;
        }
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.peek().getKey();
                int j = q.poll().getValue();
                vis[i][j] = true;
                if(isSafe(i+1, j, grid) && !vis[i+1][j]) {
                    q.add(new Pair(i+1, j));
                    q2.add(new Pair(i+1, j));
                    vis[i+1][j] = true;
                }
                if(isSafe(i, j+1, grid) && !vis[i][j+1]) {
                    q.add(new Pair(i, j+1));
                    q2.add(new Pair(i, j+1));
                    vis[i][j+1] = true;
                }
                if(isSafe(i-1, j, grid) && !vis[i-1][j]) {
                    q.add(new Pair(i-1, j));
                    q2.add(new Pair(i-1, j));
                    vis[i-1][j] = true;
                }
                if(isSafe(i, j-1, grid) && !vis[i][j-1]) {
                    q.add(new Pair(i, j-1));
                    q2.add(new Pair(i, j-1));
                    vis[i][j-1] = true;
                }
            }
        }
        while(!q2.isEmpty()) {
            int size = q2.size();
            while(size-- > 0) {
                int i = q2.peek().getKey();
                int j = q2.poll().getValue();
                
                if(isZero(i+1, j, grid) && !vis[i+1][j]) {
                    if(grid[i+1][j] == 1) return level;
                    q2.add(new Pair(i+1, j));
                    vis[i+1][j] = true;
                }
                if(isZero(i, j+1, grid) && !vis[i][j+1]) {
                    if(grid[i][j+1] == 1) return level;
                    q2.add(new Pair(i, j+1));
                    vis[i][j+1] = true;
                }
                if(isZero(i-1, j, grid) && !vis[i-1][j]) {
                    if(grid[i-1][j] == 1) return level;
                    q2.add(new Pair(i-1, j));
                    vis[i-1][j] = true;
                }
                if(isZero(i, j-1, grid) && !vis[i][j-1]) {
                    if(grid[i][j-1] == 1) return level;
                    q2.add(new Pair(i, j-1));
                    vis[i][j-1] = true;
                }
            }
            level++;
        }
        return 0;
    }
}