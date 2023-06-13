class Solution {
    public int equalPairs(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        var rows = new ArrayList<String>();
        var cols = new ArrayList<String>();
        for(int i=0; i<m; i++) {
            for(int k=0; k<m; k++) {
                var flag = true;
                for(int j=0; j<n; j++) {
                    if(grid[i][j] != grid[j][k]) flag = false;
                }
                if(flag) ans++;
            }
        }
        return ans;
    }
}