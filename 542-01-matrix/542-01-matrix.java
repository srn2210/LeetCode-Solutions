class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                res[i][j] = 1000000;
            }
        }
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    res[i][j] = 0;
                }
                else if(i-1 >= 0 && j-1 >= 0) {
                    res[i][j] = 1 + Math.min(res[i-1][j], res[i][j-1]);
                }
                else if(i-1 >= 0 && !(j-1 >= 0)) {
                    res[i][j] = 1 + res[i-1][j];
                }
                
                else if(!(i-1 >= 0) && j-1 >= 0) {
                    res[i][j] = 1 + res[i][j-1];
                }
            }
        }
        
        for(int i=mat.length-1; i>=0; i--) {
            for(int j=mat[i].length-1; j>=0; j--) {
                if(mat[i][j] == 0) {
                    res[i][j] = 0;
                }
                else if(i+1 < mat.length && j+1 < mat[i].length) {
                    res[i][j] = Math.min(res[i][j], Math.min(1+res[i+1][j], 1+res[i][j+1]));
                }
                else if(i+1 < mat.length && !(j+1 < mat[i].length)) {
                    res[i][j] = Math.min(res[i][j], 1 + res[i+1][j]);
                }
                
                else if(!(i+1 < mat.length) && j+1 < mat[i].length) {
                    res[i][j] = Math.min(res[i][j], 1 + res[i][j+1]);
                }
            }
        }        
        
        return res;
    }
}