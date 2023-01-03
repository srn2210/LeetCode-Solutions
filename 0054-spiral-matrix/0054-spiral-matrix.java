class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol) {
            
            for(int i=startCol; i<=endCol; i++) {
                res.add(matrix[startRow][i]);
            }
            
            startRow++;
            
            for(int i=startRow; i<=endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            
            endCol--;
            
            if(startRow-1 != endRow) {
                for(int i=endCol; i>=startCol; i--) {
                    res.add(matrix[endRow][i]);
                }
            }
            
            endRow--;
            
            if(startCol != endCol+1) {
                for(int i=endRow; i>=startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
            }
            
            startCol++;
        }
        
        return res;
    }
}