class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        var queue = new LinkedList<int[]>();
        var dist = new int[n][n];
        for(var arr : dist) Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int distance = 1;
        int ans = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                var t = queue.poll();
                for(int[] dir : directions) {
                    int x = dir[0] + t[0];
                    int y = dir[1] + t[1];
                    if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1 || dist[x][y] != Integer.MAX_VALUE) continue;
                    else {
                        dist[x][y] = distance;
                        ans = Math.max(ans, dist[x][y]);
                        queue.offer(new int[]{x,y});
                    }
                }
            }
            distance++;
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}