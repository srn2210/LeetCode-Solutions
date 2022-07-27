class Solution {
    int binarySearch(int[] arr, int left, int right, int target) {
        if(left > right) return -1;
        
        int mid = left + ((right - left) / 2);
        
        if(arr[mid] == target) return mid;
        
        else if(arr[mid] < target) return binarySearch(arr, mid+1, right, target);
        
        else return binarySearch(arr, left, mid-1, target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
}