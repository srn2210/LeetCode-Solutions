class Solution {
    int ans = 0;
    int collen = 0;
    int sval(int i, int j) {
        return i * collen + j;
    }
    boolean valid(int row, int col, int[][] grid, Set<Integer> set) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && (grid[row][col] == 0 || grid[row][col] == 2) && !set.contains(sval(row, col));
    }
    void backtrack(int[][] grid, Set<Integer> set, int row, int col) {
        if(set.size() == (grid.length * grid[0].length) && grid[row][col] == 2) {
            ans += 1;
            return;
        }
        else {
            if(valid(row+1, col, grid, set)) {
                set.add(sval(row+1, col));
                backtrack(grid, set, row + 1, col);
                set.remove(sval(row+1, col));
            }
            if(valid(row, col+1, grid, set)) {
                set.add(sval(row, col+1));
                backtrack(grid, set, row, col + 1);
                set.remove(sval(row, col+1));
            }
            if(valid(row, col-1, grid, set)) {
                set.add(sval(row, col-1));
                backtrack(grid, set, row, col - 1);
                set.remove(sval(row, col-1));
            }
            if(valid(row-1, col, grid, set)) {
                set.add(sval(row-1, col));
                backtrack(grid, set, row - 1, col);
                set.remove(sval(row-1, col));
            }
        }
    }
    public int uniquePathsIII(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        collen = grid[0].length;
        int startx = 0;
        int starty = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == -1) {
                    set.add(sval(i, j));
                }
                else if(grid[i][j] == 1) {
                    set.add(sval(i, j));
                    startx = i;
                    starty = j;
                }
            }
        }
        backtrack(grid, set, startx, starty);
        return ans;
    }
}