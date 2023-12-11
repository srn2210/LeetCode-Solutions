class Solution {
    boolean solve(int cand, int[] arr) {
        int left = 0, right = arr.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= cand) right = mid;
            else left = mid + 1;
        }
        int leftMost = left;
        left = 0;
        right = arr.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2 + 1;
            if(arr[mid] <= cand) left = mid;
            else right = mid - 1;
        }
        int rightMost = right;
        return rightMost - leftMost + 1 > arr.length / 4;
    }
    public int findSpecialInteger(int[] arr) {
        int cand1 = arr[arr.length/4], cand2 = arr[(int)((arr.length/4.0) * 3)], cand3 = arr[arr.length/2];
        if(solve(cand1, arr)) return cand1;
        else if(solve(cand2, arr)) return cand2;
        else return cand3;
    }
}