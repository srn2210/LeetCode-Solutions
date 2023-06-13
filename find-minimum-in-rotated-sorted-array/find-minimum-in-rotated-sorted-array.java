class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int imLeft = mid - 1 < 0 ? 0 : mid - 1;
            int imRight = mid + 1 >= nums.length-1 ? nums.length-1 : mid + 1;
            if(nums[imLeft] >= nums[mid] && nums[mid] <= nums[imRight]) {
                return nums[mid];
            }
            else if(nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return nums[left-1];
    }
}