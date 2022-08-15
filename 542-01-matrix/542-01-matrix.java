class Solution {
    /*int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
    int upl(int[][] mat, int[][] res, int row, int col) {
        if(mat[row][col] == 0) return 0;
        
        int ans = Integer.MAX_VALUE;
        
        for(int[] dir: directions) {
            int i = row + dir[0];
            int j = col + dir[1];
            
            System.out.println("row and col = "+row+". ."+col);
            
            if(i >= 0 && i<mat.length && j>=0 && j<mat[0].length) {
                System.out.println("neighbous = "+res[i][j]);
                ans = 1 + Math.min(ans, res[i][j]);
            }
        }
        
        //res[row][col] = ans;
        
        return ans;
        
    }*/
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