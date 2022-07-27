class Solution {
    int[] search(int[] arr, int target, int lo, int hi) {
        if(lo > hi) return new int[]{-1,-1};
        int mid = lo + ((hi-lo)/2);
        
        if(arr[mid] == target) {
            int temp = mid;
            while(temp > 0 && arr[mid] == arr[temp-1]) {
                temp -= 1;
            }
            int ans1 = temp;
            temp = mid;
            while(temp < arr.length-1 && arr[mid] == arr[temp + 1]) {
                temp += 1;
            }
            int ans2 = temp;
            return new int[]{ans1, ans2};
        }
        
        else if(arr[mid] < target) {
            return search(arr, target, mid+1, hi);
        }
        
        else {
            return search(arr, target, lo, mid-1);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1, -1};
        }
        return search(nums, target, 0, nums.length-1);
    }
}