class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i=1; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = t+matrix[i-1][j];
                if(j - 1 >= 0) matrix[i][j] = Math.min(t + matrix[i-1][j-1], matrix[i][j]);
                if(j + 1 < matrix[0].length) matrix[i][j] = Math.min(t + matrix[i-1][j+1], matrix[i][j]);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<matrix[0].length; i++) {
            ans = Math.min(ans, matrix[matrix.length-1][i]);
        }
        return ans;
    }
}