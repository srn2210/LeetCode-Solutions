class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                col[j] = col[j] + mat[i][j];
                row[i] = row[i] + mat[i][j];
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1) ans++;
            }
        }
        return ans;
    }
}