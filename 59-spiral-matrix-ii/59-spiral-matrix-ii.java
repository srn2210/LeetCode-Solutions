class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int layer = (n+1)/2;
        int count = 1;
        
        for(int i = 0; i<layer; i++){
            for(int j=i; j<n-i; j++){
                matrix[i][j] = count;
                count++;
            }
            for(int j=i+1; j<n-i; j++){
                matrix[j][n-i-1] = count;
                count++;
            }
            for(int j=n-i-2; j>=i; j--){
                matrix[n-i-1][j] = count;
                count++;
            }
            for(int j=n-i-2; j>=i+1; j--){
                matrix[j][i] = count;
                count++;
            }
        }
        
        return matrix;
    }
}