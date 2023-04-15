class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                var s = Integer.toString(grid[i][j]);
                ans[j] = Math.max(ans[j], s.length());
            }
        }
        return ans;
    }
}