class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long l = Integer.MIN_VALUE - 1l, r = Integer.MIN_VALUE - 1l;
            l = mid - 1 >= 0 ? nums[mid - 1] : l;
            r = mid + 1 < nums.length ? nums[mid + 1] : r;
            if(nums[mid] > l && nums[mid] > r) return mid;
            else if(nums[mid] > l && r > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}