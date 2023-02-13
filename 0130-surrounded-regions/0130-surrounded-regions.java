class Solution {
    public void solve(char[][] board) {
        var m = board.length;
        var n = board[0].length;
        var queue = new LinkedList<int[]>();
        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') queue.offer(new int[]{i,0});
            if(board[i][n-1] == 'O') queue.offer(new int[]{i,n-1});
        }
        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O') queue.offer(new int[]{0,i});
            if(board[m-1][i] == 'O') queue.offer(new int[]{m-1,i});
        }
        int[][] directions = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                var t = queue.poll();
                if(board[t[0]][t[1]] != 'O') continue;
                else {
                    board[t[0]][t[1]] = 'I';
                    for(var dir : directions) {
                        int x = dir[0] + t[0];
                        int y = dir[1] + t[1];
                        if(x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') continue;
                        else {
                            queue.add(new int[]{x,y});
                        }
                    }
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] != 'I') board[i][j] = 'X';
                else board[i][j] = 'O';
            }
        }
    }
}