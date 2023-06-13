class Solution {
    public int equalPairs(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var rows = new ArrayList<String>();
        var cols = new ArrayList<String>();
        for(int i=0; i<m; i++) {
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n; j++) {
                row.append(grid[i][j]);
                row.append(',');
            }
            rows.add(row.toString());
        }
        for(int i=0; i<n; i++) {
            StringBuilder col = new StringBuilder();
            for(int j=0; j<m; j++) {
                col.append(grid[j][i]);
                col.append(',');
            }
            cols.add(col.toString());
        }
        int ans = 0;
        for(var row : rows) {
            for(var col : cols) {
                if(row.equals(col)) ans++;
            }
        }
        return ans;
    }
}