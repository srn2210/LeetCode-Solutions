class Solution {
    int count(int[][] arr, int x) {
        int row = 0;
        int col = arr[0].length-1;
        int c = 0;
        while(row < arr.length && col >= 0) {
            if(arr[row][col] <= x) {
                c += col + 1;
                row++;
            }
            else col--;
        }
        return c;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        int ans = 0;
        
        while(lo != hi) {
            int mid = lo + ((hi-lo)/2);
            ans = count(matrix, mid);            
            if(ans < k) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        
        return hi;
    }
}