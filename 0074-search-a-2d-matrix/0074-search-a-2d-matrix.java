class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] t = new int[matrix[0].length];
        t[t.length-1] = target;
        int ans = Arrays.binarySearch(matrix, t, Comparator.comparingInt(j -> j[matrix[0].length-1]));
        if(ans >= 0) return true;
        else {
            ans = -ans - 1;
            if(ans >= matrix.length) return false;
            ans = Arrays.binarySearch(matrix[ans], target);
        }
        return ans >= 0 ? true : false;
    }
}