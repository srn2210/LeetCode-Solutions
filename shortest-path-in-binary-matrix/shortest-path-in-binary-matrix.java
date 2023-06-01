class Solution {
    int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    boolean isSafe(int x, int y, int[][] grid) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int m = grid.length, n = grid[0].length;
        var q = new LinkedList<int[]>();
        var vis = new boolean[m][n];
        q.add(new int[]{0,0});
        vis[0][0] = true;
        int distance = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                var arr = q.poll();
                if(arr[0] == m-1 && arr[1] == n-1) return distance;
                for(int[] dir : directions) {
                    int x = dir[0] + arr[0];
                    int y = dir[1] + arr[1];
                    if(isSafe(x, y, grid) && !vis[x][y]) {
                        vis[x][y] = true;
                        q.add(new int[]{x,y});
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}