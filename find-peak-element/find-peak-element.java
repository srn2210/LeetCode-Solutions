class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        long min = Integer.MIN_VALUE - 1l;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            long l = min, r = min;
            l = mid - 1 >= 0 ? nums[mid - 1] : l;
            r = mid + 1 < nums.length ? nums[mid + 1] : r;
            if(nums[mid] > l && nums[mid] > r) return mid;
            else if(nums[mid] > l && r > nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}