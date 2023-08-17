class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
    boolean notSafe(int i, int j, int[][] mat, boolean[][] vis) {
        return i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j];
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        var q = new LinkedList<int[]>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int[][] ans = new int[m][n];
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] arr = q.poll();
                int i = arr[0];
                int j = arr[1];
                for(int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(notSafe(x, y, mat, vis)) continue;
                    else {
                        vis[x][y] = true;
                        if(mat[x][y] == 1) ans[x][y] = dist;
                        q.add(new int[]{x,y});
                    }
                }
            }
            dist++;
        }
        return ans;
    }
}