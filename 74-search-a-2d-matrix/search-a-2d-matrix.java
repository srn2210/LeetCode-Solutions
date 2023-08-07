class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length-1;
        while(left < right) {
            int mid = (left + (right - left) / 2) + 1;
            if(matrix[mid][0] > target) right = mid - 1;
            else left = mid;
        }
        int l = 0, r = matrix[0].length-1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(matrix[left][mid] < target) l = mid + 1;
            else r = mid;
        }
        return matrix[left][l] == target;
    }
}