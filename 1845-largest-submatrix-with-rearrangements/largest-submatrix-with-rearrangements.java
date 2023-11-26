class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for(int j=0; j<n; j++) {
            for(int i=0; i<m; i++) {
                if(matrix[i][j] != 0 && i-1 >= 0) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        for(int[] mat : matrix) {
            Arrays.sort(mat);
            //System.out.println(Arrays.toString(mat));
        }
        int ans = 0;
        for(int[] mat : matrix) {
            int count = 0, min = (int)1e9;
            for(int j=n-1; j>=0; j--) {
                int ma = mat[j];
                if(ma > 0) {
                    count++;
                    min = Math.min(min, ma);
                    ans = Math.max(ans, count * min);
                }
            }
        }
        return ans;
    }
}