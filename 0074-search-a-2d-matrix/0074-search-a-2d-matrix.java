class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] t = new int[n];
        t[n-1] = target;
        int ans = Arrays.binarySearch(matrix, t, (a,b) -> a[n-1] - b[n-1]);
        if(ans >= 0) return true;
        else {
            ans = -ans - 1;
            if(ans >= m) return false;
            ans = Arrays.binarySearch(matrix[ans], target);
        }
        return ans >= 0 ? true : false;
    }
}