class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    boolean notSafe(String[] grid, int row, int col) {
        return row < 0 || col < 0 || row >= grid.length || col >= grid[row].length() || grid[row].charAt(col) == '#';
    }
    public int shortestPathAllKeys(String[] grid) {
        int k = 0, m = grid.length, n = grid[0].length();
        var map = Map.of('a', 0, 'b', 1, 'c', 2, 'd', 3, 'e', 4, 'f', 5);
        var vis = new boolean[64][m][n];
        var q = new LinkedList<int[]>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length(); j++) {
                var ch = grid[i].charAt(j);
                if(ch >= 'a' && ch <= 'f') k++;
                else if(ch == '@') {
                    vis[0][i][j] = true;
                    q.add(new int[]{i, j, 0, 0});
                }
            }
        }
        int res = (1 << k) - 1;
        while(!q.isEmpty()) {
            var arr = q.poll();
            int mask = arr[2];
            int steps = arr[3];
            if(mask == res) return steps;
            for(var dir : directions) {
                int x = dir[0] + arr[0];
                int y = dir[1] + arr[1];
                if(notSafe(grid, x, y)) continue;
                else {
                    var ch = grid[x].charAt(y);
                    if(Character.isLowerCase(ch)) {
                        int t = mask | (1 << map.get(ch));
                        if(vis[t][x][y]) continue;
                        vis[t][x][y] = true;
                        q.add(new int[]{x, y, t, steps+1});
                    }
                    else if(Character.isUpperCase(ch)) {
                        int num = map.get(Character.toLowerCase(ch));
                        if(vis[mask][x][y]) continue;
                        if(((1 << num) & mask) != 0) {
                            vis[mask][x][y] = true;
                            q.add(new int[]{x, y, mask, steps+1});
                        }
                    }
                    else {
                        if(vis[mask][x][y]) continue;
                        vis[mask][x][y] = true;
                        q.add(new int[]{x, y, mask, steps+1});
                    }
                }
            }
        }
        return -1;
    }
}