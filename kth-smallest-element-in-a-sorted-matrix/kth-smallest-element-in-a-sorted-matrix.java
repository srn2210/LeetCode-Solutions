class Solution {
    boolean safe(int cand, int[][] matrix, int k) {
        int row = 0, col = matrix.length-1;
        int count = 0;
        while(col >= 0 && row < matrix.length) {
            if(cand >= matrix[row][col]) {
                count += col + 1;
                row++;
            }
            else col--;
        }
        return count >= k;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(safe(mid, matrix, k)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}