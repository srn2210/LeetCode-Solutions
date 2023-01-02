class NumMatrix {
    int[][] presum;
    int m;
    int n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        presum = new int[m][n];
        presum[0][0] = matrix[0][0];
        for(int i=1; i<n; i++) {
            presum[0][i] = matrix[0][i] + presum[0][i-1];
        }
        for(int i=1; i<m; i++) {
            presum[i][0] = matrix[i][0] + presum[i-1][0];
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                presum[i][j] = matrix[i][j] + presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int i1 = Math.max(row1, row2);
        int i2 = Math.min(row1, row2);
        int j1 = Math.max(col1, col2);
        int j2 = Math.min(col1, col2);
        int x = i2-1 >= 0 ? presum[i2-1][j1] : 0;
        int y = j2-1 >= 0 ? presum[i1][j2-1] : 0;
        int z = i2-1 >= 0 && j2-1 >= 0 ? presum[i2-1][j2-1] : 0;
        return presum[i1][j1] - x - y + z;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */