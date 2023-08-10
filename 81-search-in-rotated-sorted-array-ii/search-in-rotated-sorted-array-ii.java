class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            else if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid;
                }
                else left = left + 1;
            }
            else {
                if(nums[mid] < target && target <= nums[right]) left = mid;
                else right = right - 1;
            }
        }
        return nums[left] == target;
    }
}