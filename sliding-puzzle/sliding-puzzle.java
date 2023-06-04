class Solution {
    int[] directions = new int[]{1,0,-1,0,1};
    boolean done(int[][] board) {
        int prev = 1;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(i == board.length-1 && j == board[0].length-1) return true;
                if(prev != board[i][j]) return false;
                prev++;
            }
        }
        return true;
    }
    void swap(int i, int j, int x, int y, int[][] board) {
        int t = board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = t;
    }
    boolean safe(int[][] board, int row, int col) {
        return !(row >= board.length || col >= board[0].length || row < 0 || col < 0);
    }
    String serialize(int[][] board) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                res.append(String.valueOf(board[i][j]));
                res.append("_");
            }
        }
        return res.toString();
    }
    /*int backtrack(int[][] board, int row, int col, Set<String> vis) {
        if(done(board)) return 0;
        if(!safe(board, row, col)) return 1000;
        String str = serialize(board);
        if(vis.contains(str)) return 1000;
        else vis.add(str);
        int ans = Integer.MAX_VALUE;
        for(int dir=0; dir<directions.length-1; dir++) {
            int x = row + directions[dir];
            int y = col + directions[dir+1];
            if(safe(board, x, y)) {
                swap(row, col, x, y, board);
                ans = Math.min(ans, 1 + backtrack(board, x, y, vis));
                swap(x, y, row, col, board);
            }
        }
        return ans;
    }*/
    int[][] copy(int[][] g) {
        int[][] ans = new int[g.length][g[0].length];
        for(int i=0; i<g.length; i++) {
            for(int j=0; j<g[0].length; j++) {
                ans[i][j] = g[i][j];
            }
        }
        return ans;
    }
    public int slidingPuzzle(int[][] board) {
        int ans = 0;
        var vis = new HashSet<String>();
        var q = new LinkedList<Pair<int[][], int[]>>();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 0) {
                    q.add(new Pair<>(board,new int[]{i,j}));
                }
            }
        }
        vis.add(serialize(board));
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int i = q.peek().getValue()[0];
                int j = q.peek().getValue()[1];
                var grid = q.poll().getKey();
                if(done(grid)) return ans;
                for(int dir=0; dir<4; dir++) {
                    int x = i + directions[dir];
                    int y = j + directions[dir+1];
                    if(safe(grid, x, y)) {
                        var temp = copy(grid);
                        //for(int[] a : grid) System.out.println(Arrays.toString(a));
                        //System.out.println(" --------------- ");
                        swap(i, j, x, y, temp);
                        var s = serialize(temp);
                        if(vis.contains(s)) continue;
                        //System.out.println(s);
                        
                        vis.add(s);
                        q.add(new Pair<>(temp, new int[]{x,y}));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}