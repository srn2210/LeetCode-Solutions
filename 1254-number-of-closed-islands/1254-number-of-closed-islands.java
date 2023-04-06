class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    void bfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        var queue = new LinkedList<int[]>();
        queue.add(new int[]{i,j});
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                var curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for(var dir : directions) {
                    int r = x + dir[0];
                    int c = y + dir[1];
                    if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0 || visited[r][c]) continue;
                    else {
                        visited[r][c] = true;
                        queue.add(new int[]{r,c});
                    }
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            if(grid[i][0] == 0 && !visited[i][0]) bfs(grid, i, 0, visited);
            if(grid[i][n-1] == 0 && !visited[i][n-1]) bfs(grid, i, n-1, visited);
        }
        for(int i=0; i<n; i++) {
            if(grid[0][i] == 0 && !visited[0][i]) bfs(grid, 0, i, visited);
            if(grid[m-1][i] == 0 && !visited[m-1][i]) bfs(grid, m-1, i, visited);
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && grid[i][j] == 0) {
                    ans++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return ans;
    }
}