class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid[0].length, ans = 0;
        var rows = new HashMap<String, Integer>();
        for(int i=0; i<n; i++) {
            var sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                sb.append(grid[i][j]).append(',');
            }
            var s = sb.toString();
            rows.put(s, rows.getOrDefault(s, 0) + 1);
        }
        for(int j=0; j<n; j++) {
            var sb = new StringBuilder();
            for(int i=0; i<n; i++) {
                sb.append(grid[i][j]).append(',');
            }
            var s = sb.toString();
            ans += rows.getOrDefault(s, 0);
        }
        return ans;
    }
}