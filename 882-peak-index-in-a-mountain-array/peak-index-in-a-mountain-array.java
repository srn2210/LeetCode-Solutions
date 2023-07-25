class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1, right = arr.length-2;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[mid+1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}