class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    void bfs(int i, int j, char[][] grid, boolean[][] vis) {
        Deque<int[]> queue = new ArrayDeque();
        vis[i][j] = true;
        queue.addLast(new int[]{i,j});
        while(!queue.isEmpty()) {
            int[] temp = queue.removeFirst();
            for(int[] dir:directions) {
                int x = temp[0] + dir[0];
                int y = temp[1] + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !vis[x][y]) {
                    vis[x][y] = true;
                    queue.addLast(new int[]{x,y});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(!vis[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, grid, vis);
                }
                else {
                    vis[i][j] = true;
                }
            }
        }
        return ans;
    }
}