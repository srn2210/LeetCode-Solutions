class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = 0, j = grid[0].length-1, count = 0;
        while(j >= 0 && i < m) {
            if(j >= 0 && grid[i][j] < 0) j--;
            else {
                count += n - j - 1;
                i++;
            }
        }
        if(j < 0) {
            count += (m - i) * (n);
        }
        return count;
    }
}